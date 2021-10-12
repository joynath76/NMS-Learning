package com.spring.nmsjpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    private String ID;
    private String name;
    private String desc;

    public Menu() {
    }

    public Menu(String iD, String name, String desc) {
        ID = iD;
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Menu [ID=" + ID + ", desc=" + desc + ", name=" + name + "]";
    }
    

}
