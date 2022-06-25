package com.jtmc.apps.reforma.domain;

import java.time.Instant;

public class PersonaRolePeriodConfirmation {
    private int personaId;
    private Instant confirmationDate;
    private Role role;

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public Instant getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Instant confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
