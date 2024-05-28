package com.jtmc.apps.reforma.api.v1.annotations;

public class JwtUserClaim {

    private String subject;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}
