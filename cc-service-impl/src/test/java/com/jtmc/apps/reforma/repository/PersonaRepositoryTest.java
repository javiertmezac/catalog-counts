package com.jtmc.apps.reforma.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Date;

@RunWith(BlockJUnit4ClassRunner.class)
public class PersonaRepositoryTest {

   @InjectMocks
   private PersonaRepository personaRepository;

   private ArrayList<Persona> listOfPersons;
   private Date randomDate;

    @Before
    public void setUp() throws Exception {
        listOfPersons = new ArrayList<>();
        randomDate = new Date();
        listOfPersons.add(new Persona("random", randomDate));
    }

    @Test
    public void getListOfPersons() throws Exception {
        personaRepository.getListOfPersons();
    }

    @Test
    public void addNewPerson() throws Exception {
    }

    @Test
    public void getMostRecentVisit() throws Exception {
    }

    @Test
    public void getFarthestVisit() throws Exception {
    }

    @Test
    public void printAllList() throws Exception {
    }
}
