package com.jtmc.apps.reforma.impl.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.ImplementationException;
import com.jtmc.apps.reforma.impl.exception.UserNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.LoginRepositoryImpl;
import com.jtmc.apps.reforma.repository.PersonaRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Optional;

public class LoginApplication {
    final private Logger logger = LoggerFactory.getLogger(LoginApplication.class);

    @Inject
    private LoginRepositoryImpl userRepository;

    @Inject
    private PersonaRepository personaRepository;

    @Inject
    private UserImpl userImpl;

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    private ObjectMapper objectMapper;

    public Login selectUser(String inputUsername, String inputPassword) {
        logger.debug("Provided Username: {}", inputUsername);

        Optional<Login> user = userRepository.selectUser(inputUsername, inputPassword);
        if (!user.isPresent()) {
            logger.warn("UserLogin not found for provided credentials");
            //todo: should this be a different error message?
            throw new UserNotFoundException("Bad Request", 400);
        }
        return user.get();
    }

    public void insert(String password, String username, int personaId) {

        UserDetails userDetails = userImpl.validateAdminPermissionsForLoggedInUser();
        logger.info("username {}", userDetails.getUsername());

        Optional<Persona> persona = personaRepository.selectOne(personaId);
        if(!persona.isPresent()) {
            logger.error("cannot insert login registry, personaId {}, not found", personaId);
            throw new ImplementationException("could not insert registry", 400);
        }

        Login registration = new Login();
        registration.setPassword(password);
        registration.setUsername(username);
        registration.setPersonaid(personaId);
        registration.setRegistration(Instant.now());

        int successfulInsertion = 1;
        if(userRepository.insert(registration) != successfulInsertion) {
           logger.error("could not insert new login registration");
           throw new ImplementationException("Error inserting registry", 500);
        }

        logger.info("new login registry successfully inserted username {} for persona {}",
                username, persona.get().getName() + " " + persona.get().getLastname());
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
