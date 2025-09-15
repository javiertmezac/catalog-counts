package com.jtmc.apps.reforma.api.v1.persona;

import java.util.List;

public class PersonaResponse {

    private int id;
    private String name;
    private String lastname;
    private String registration;
    private boolean status;
    private List<PersonaRequest.BranchAndRole> branchesAndRoles;

    public List<PersonaRequest.BranchAndRole> getBranchesAndRoles() {
        return branchesAndRoles;
    }

    public void setBranchesAndRoles(List<PersonaRequest.BranchAndRole> branchesAndRoles) {
        this.branchesAndRoles = branchesAndRoles;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
