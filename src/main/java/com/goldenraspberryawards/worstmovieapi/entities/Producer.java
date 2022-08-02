package com.goldenraspberryawards.worstmovieapi.entities;

import javax.persistence.Entity;

@Entity
public class Producer extends DefaultEntity {

    private String name;

    public Producer() {
    }

    public Producer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
