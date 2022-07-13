package com.jtmc.apps.reforma.api.v1.login;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.impl.login.LoginApplication;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class LoginApiImpl implements LoginApi {
    final private Logger logger = LoggerFactory.getLogger(LoginApiImpl.class);

    @Inject
    private LoginApplication loginApp;

    @Override
    public LoginResponse login(String email, String password) {
        checkArgument(StringUtils.isNotBlank(email));
        checkArgument(StringUtils.isNotBlank(password));

        Login user = loginApp.selectUser(email, password);
        String jws = loginApp.buildJWS(user.getUsername());

        LoginResponse response = new LoginResponse();
        response.setId_token(jws);
        return  response;
    }

    @Override
    public Response register(LoginRegistrationRequest request) {
        checkNotNull(request, "Invalid registration login payload");
        checkArgument(StringUtils.isNotBlank(request.getPassword()), "Invalid password");
        checkArgument(StringUtils.isNotBlank(request.getUsername()), "Invalid username");
        checkArgument(request.getPersonaId() > 0, "Invalid personaId");

        loginApp.insert(request.getPassword(), request.getUsername(), request.getPersonaId());
        return Response.noContent().build();
    }
}
