package com.jtmc.apps.reforma.api.v1.user;

public class UserResponse {
    private String[] roles;
    private int defaultBranch;
    private String username;

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
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