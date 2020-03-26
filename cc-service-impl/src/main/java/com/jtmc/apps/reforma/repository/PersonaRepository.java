package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonaRepository {

    private List<Persona> listOfPersons;

    public PersonaRepository() {
        this.listOfPersons = new ArrayList<Persona>();
    }

    public List<Persona> getListOfPersons() {
        return listOfPersons;
    }

    public void addNewPerson(Persona person){
        this.listOfPersons.add(person);
    }

    public Persona getMostRecentVisit() {
        Date tempDate = new Date();
        System.out.println(tempDate);
        Persona persona = null;

        for (Persona p:listOfPersons) {
           if (p.getLastTimeVisited() != null && p.getLastTimeVisited().before(tempDate)) {
               tempDate = p.getLastTimeVisited();
               persona = p;
           }
        }
        return persona;
    }

    public Persona getFarthestVisit() {

        return null;
    }


    public void printAllList() {
        listOfPersons.forEach(x -> System.out.println(x.toString()));
    }
}
