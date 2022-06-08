package com.jtmc.apps.reforma.impl.personadetails;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PersonaDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonaDetailsImpl {
    private Logger logger = LoggerFactory.getLogger(PersonaDetailsImpl.class);

    @Inject
    private PersonaDetailsRepository repository;

    @Inject
    private UserImpl userImpl;

    public List<PersonaDetails> select() {
       return repository.selectAll();
    }

    public void insert(PersonaDetails persona) {
        userImpl.getLoggedInUserDetails();
        if (repository.insert(persona) != 1) {
            logger.error("PersonaDetails was not inserted. {}", persona);
            throw new RuntimeException("PersonaDetails was not inserted.");
        }
    }
}
