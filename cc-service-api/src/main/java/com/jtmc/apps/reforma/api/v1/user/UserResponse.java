package com.jtmc.apps.reforma.api.v1.user;

import java.util.List;

public class UserResponse {
    private List<Integer> roles;
    private List<Integer> branches;
    private int defaultBranch;
    private String username;
    private int userId;

    public List<Integer> getBranches() {
        return branches;
    }

    public void setBranches(List<Integer> branches) {
        this.branches = branches;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
