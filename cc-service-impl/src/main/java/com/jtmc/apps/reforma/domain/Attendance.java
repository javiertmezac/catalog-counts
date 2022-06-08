package com.jtmc.apps.reforma.domain;

import com.jtmc.apps.reforma.domain.legacy.Persona;

public class Attendance {

    private Persona persona;
    private boolean attended;

    public com.jtmc.apps.reforma.domain.legacy.Persona getPersona() {
        return persona;
    }

    public void setPersona(com.jtmc.apps.reforma.domain.legacy.Persona persona) {
        this.persona = persona;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
