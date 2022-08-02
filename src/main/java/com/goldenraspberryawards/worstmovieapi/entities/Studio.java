package com.goldenraspberryawards.worstmovieapi.entities;

import javax.persistence.Entity;

@Entity
public class Studio extends DefaultEntity {

    private String name;

    public Studio() {
    }

    public Studio(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
