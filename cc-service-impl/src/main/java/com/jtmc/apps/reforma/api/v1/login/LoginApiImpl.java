package com.jtmc.apps.reforma.api.v1.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.impl.login.LoginImpl;
import com.jtmc.apps.reforma.impl.persona.PersonaImpl;
import com.jtmc.apps.reforma.impl.personadetails.PersonaDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class LoginApiImpl implements LoginApi {
    final private Logger logger = LoggerFactory.getLogger(LoginApiImpl.class);

    @Inject
    private LoginImpl loginImpl;

    @Inject
    private PersonaDetailsImpl personaDetailsImpl;

    @Inject
    private PersonaImpl personaImpl;

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    @Named("defaultExpiration")
    private int defaultExpiration;

    @Inject
    private ObjectMapper objectMapper;

    @Override
    public LoginResponse login(String email, String password) {
        checkArgument(StringUtils.isNotBlank(email));
        checkArgument(StringUtils.isNotBlank(password));

        Login user = loginImpl.selectUser(email, password);
        String jws = buildJWS(user.getUsername(), user.getPersonaid());

        LoginResponse response = new LoginResponse();
        response.setId_token(jws);
        return  response;
    }

    private String buildJWS(String username, int userId) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Instant now = Instant.now();
        Date issueAtDate = new Date(now.toEpochMilli());
        Date expirationDate = new Date(now.plusSeconds(defaultExpiration).toEpochMilli());

        return Jwts
                .builder()
                .serializeToJsonWith(new JacksonSerializer(objectMapper))
                .claim("uid", userId)
                .setSubject(username)
                .setIssuedAt(issueAtDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    @Override
    public Response register(LoginRegistrationRequest request) {
        checkNotNull(request, "Invalid registration login payload");
        checkArgument(StringUtils.isNotBlank(request.getPassword()), "Invalid password");
        checkArgument(StringUtils.isNotBlank(request.getUsername()), "Invalid username");
        checkArgument(request.getPersonaId() > 0, "Invalid personaId");

        Persona persona = personaImpl.selectOne(request.getPersonaId());
        loginImpl.validatePersonaHasActiveAccount(persona.getId());

        loginImpl.insert(request.getPassword(), request.getUsername(), persona);
        return Response.noContent().build();
    }
}
