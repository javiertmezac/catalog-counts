package com.jtmc.apps.reforma.domain.legacy;

import java.util.Date;

public class Persona {

    private int id;
    private String name;
    private String lastname;
    private Date lastTimeVisited;

    public Persona(String name) {
       this.name = name;
    }

    public Persona(String name, Date lastTimeVisited) {
        this.name = name;
        this.lastTimeVisited = lastTimeVisited;
    }

    public Persona() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getLastTimeVisited() {
        return lastTimeVisited;
    }

    public void setLastTimeVisited(Date lastTimeVisited) {
        this.lastTimeVisited = lastTimeVisited;
    }

    @Override
    public String toString() {
        return "com.jtmc.apps.reforma.domain.legacy.Persona{" +
                "name='" + name + '\'' +
                "lastname='" + lastname + '\'' +
                ", lastTimeVisited=" + lastTimeVisited +
                '}';
    }
}
