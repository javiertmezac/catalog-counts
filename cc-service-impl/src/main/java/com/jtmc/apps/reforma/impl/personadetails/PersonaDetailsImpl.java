package com.jtmc.apps.reforma.impl.personadetails;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PersonaDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

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

    public Optional<PersonaDetails> selectFirstOrDefaultByPersona(int personaId) {
        return repository.selectByPersonaId(personaId).stream().findFirst();
    }

    public List<PersonaDetails> findByPersonaId(int personaId) {
       return repository.selectByPersonaId(personaId);
    }
}
