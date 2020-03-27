package com.jtmc.apps.reforma.domain;

import java.util.Date;

public class Persona {

    private String name;
    private Date lastTimeVisited;

    public Persona(String name) {
       this.name = name;
    }

    public Persona(String name, Date lastTimeVisited) {
        this.name = name;
        this.lastTimeVisited = lastTimeVisited;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Date getLastTimeVisited() {
        return lastTimeVisited;
    }

    public void setLastTimeVisited(Date lastTimeVisited) {
        this.lastTimeVisited = lastTimeVisited;
    }

    @Override
    public String toString() {
        return "com.jtmc.apps.reforma.domain.Persona{" +
                "name='" + name + '\'' +
                ", lastTimeVisited=" + lastTimeVisited +
                '}';
    }
}
