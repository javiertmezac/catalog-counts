package com.jtmc.apps.reforma.api.filter;

import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.annotation.Priority;
import javax.crypto.SecretKey;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
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
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwsString);
            userClaim.setSubject(claims.getBody().getSubject());
        } catch (JwtException exception) {
            exception.printStackTrace();
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }
}
