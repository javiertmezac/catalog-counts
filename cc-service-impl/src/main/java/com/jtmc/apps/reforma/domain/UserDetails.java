package com.jtmc.apps.reforma.domain;

import java.util.List;

public class UserDetails {
    private List<Integer> roles;
    private Role defaultRole;
    private List<Integer> branches;
    private int defaultBranch;
    private String username;
    private int personaId;

    public Role getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Role defaultRole) {
        this.defaultRole = defaultRole;
    }

    public List<Integer> getBranches() {
        return branches;
    }

    public void setBranches(List<Integer> branches) {
        this.branches = branches;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public int getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(int defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
