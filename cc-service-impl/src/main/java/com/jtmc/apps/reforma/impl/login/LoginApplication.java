package com.jtmc.apps.reforma.impl.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.impl.exception.UserNotFoundException;
import com.jtmc.apps.reforma.repository.LoginRepositoryImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LoginApplication {
    final private Logger logger = LoggerFactory.getLogger(LoginApplication.class);

    @Inject
    private LoginRepositoryImpl userRepository;

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    private ObjectMapper objectMapper;

    public Login selectUser(String inputUsername, String inputPassword) {
        logger.debug("Provided Username: {}", inputUsername);

        Optional<Login> user = userRepository.selectUser(inputUsername, inputPassword);
        if (!user.isPresent()) {
            logger.warn("User not found for provided credentials");
            throw new UserNotFoundException("Bad Request", 400);
        }
        return user.get();
    }

    public String buildJWS(String username) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .builder()
                .serializeToJsonWith(new JacksonSerializer(objectMapper))
                .setSubject(username)
                .signWith(key)
                .compact();
    }
}
