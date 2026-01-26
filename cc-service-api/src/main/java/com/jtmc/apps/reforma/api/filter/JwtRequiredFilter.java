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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtRequiredFilter implements ContainerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtRequiredFilter.class);

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    private JwtUserClaim userClaim;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        String path = containerRequestContext.getUriInfo().getPath();

        if (path.startsWith("public") || path.startsWith("login")) {
            return;
        }

        String authHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            containerRequestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Missing or invalid Authorization header")
                            .build()
            );
            return;
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
            containerRequestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Authorization Expired")
                            .build()
            );
        } catch (JwtException exception) {
            logger.error("", exception);
            containerRequestContext.abortWith(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
            );
        }
    }
}
