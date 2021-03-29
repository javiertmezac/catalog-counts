package com.jtmc.apps.reforma.api.v1.service;

import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;

public class Attendance {

    private int id;
    private PersonaResponse persona;
    private boolean attended;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonaResponse getPersona() {
        return persona;
    }

    public void setPersona(PersonaResponse persona) {
        this.persona = persona;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
