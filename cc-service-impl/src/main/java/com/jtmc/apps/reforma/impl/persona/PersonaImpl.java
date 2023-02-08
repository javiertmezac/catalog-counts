package com.jtmc.apps.reforma.impl.persona;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.impl.exception.PersonaNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class PersonaImpl {
    private Logger logger = LoggerFactory.getLogger(PersonaImpl.class);

    @Inject
    private PersonaRepository repository;

    @Inject
    private UserImpl userImpl;

    public Persona selectOne(int id) {
        Optional<Persona> repo = repository.selectOne(id);
        if (!repo.isPresent()) {
            logger.error("Persona #{} not found", id);
            throw new PersonaNotFoundException("Persona not found", 404);
        }
        return repo.get();
    }

    public List<Persona> select() {
       return repository.selectAll();
    }

    public void insert(Persona persona) {
        userImpl.validateAdminPermissionsForLoggedInUser();
        if (repository.insert(persona) != 1) {
            logger.error("Persona was not inserted. {}", persona);
            throw new RuntimeException("Persona was not inserted.");
        }
    }
}
