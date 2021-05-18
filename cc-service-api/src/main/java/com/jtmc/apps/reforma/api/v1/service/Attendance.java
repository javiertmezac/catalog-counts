package com.jtmc.apps.reforma.api.v1.service;

import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;

public class Attendance {

    private PersonaResponse persona;
    private boolean attended;

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
