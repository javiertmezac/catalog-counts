package com.jtmc.apps.reforma.api.v1.annotations;

public class JwtUserClaim {

    private String subject;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}
