package com.jtmc.apps.reforma.api.v1.persona;

public class PersonaRequest {

    private String name;
    private String lastname;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static class BranchAndRole {
        public int branchId;
        public int roleId;
        public String roleName;
        public String entryDate;
    }
}
