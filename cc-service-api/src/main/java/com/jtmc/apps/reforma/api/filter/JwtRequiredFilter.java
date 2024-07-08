package com.jtmc.apps.reforma.api.filter;

import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Provider
@JwtRequired
@Priority(Priorities.AUTHENTICATION)
public class JwtRequiredFilter implements ContainerRequestFilter {

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    private JwtUserClaim userClaim;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if(authHeader == null || authHeader.isEmpty() || authHeader.trim().isEmpty()) {
            throw new WebApplicationException("Expected Authorization Header", Response.Status.BAD_REQUEST);
        }

        try {
            String authPrefix = "Bearer";
            String jwsString = authHeader.substring(authPrefix.length()).trim();

            SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
            Jws<Claims> claims = Jwts.parser().verifyWith(key)
                    .build()
                    .parseSignedClaims(jwsString);

            userClaim.setSubject(claims.getPayload().getSubject());
            userClaim.setId((Integer)claims.getPayload().get("uid"));

        } catch (ExpiredJwtException ex) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        } catch (JwtException exception) {
            exception.printStackTrace();
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
