package com.jtmc.apps.reforma.impl.login;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.ImplementationException;
import com.jtmc.apps.reforma.impl.persona.PersonaImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.LoginRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

public class LoginImpl {
    final private Logger logger = LoggerFactory.getLogger(LoginImpl.class);

    @Inject
    private LoginRepositoryImpl loginRepository;

    @Inject
    private PersonaImpl personaImpl;

    @Inject
    private UserImpl userImpl;


    public Login selectUser(String inputUsername, String inputPassword) {
        logger.debug("Provided Username for login: {}", inputUsername);

        Optional<Login> user = loginRepository.selectUser(inputUsername, base64Encode(inputPassword));
        if (!user.isPresent()) {
            logger.warn("UserLogin not found for provided credentials");
            throw new BadRequestException();
        }

        return user.get();
    }

    public void insert(String password, String username, int personaId) {

        UserDetails userDetails = userImpl.validateAdminPermissionsForLoggedInUser();
        logger.info("username {}", userDetails.getUsername());

        Persona persona = personaImpl.selectOne(personaId);

        Login registration = new Login();
        registration.setPassword(base64Encode(password));
        registration.setUsername(username);
        registration.setPersonaid(personaId);
        registration.setRegistration(Instant.now());

        int successfulInsertion = 1;
        if(loginRepository.insert(registration) != successfulInsertion) {
           logger.error("could not insert new login registration for new username {} and personaId {}",
                   username, personaId);
           throw new ImplementationException("Error inserting registry", 500);
        }

        logger.info("new login registry successfully inserted for username {} and persona {}",
                username, String.format("%s %s", persona.getName(), persona.getLastname()));
    }

    private String base64Encode(String value) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] toEncode = value.getBytes(StandardCharsets.UTF_8);
        return encoder.encodeToString(toEncode);
    }
}
