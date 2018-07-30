package com.mohammadreza_mirali.cvs_to_db_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mmirali on 30/07/2018.
 */
@Entity
public class Bank {
    @Id
    @Column
    private Integer identifire;

    @Column
    private String name;

    public Integer getIdentifire() {
        return identifire;
    }

    public void setIdentifire(Integer identifire) {
        this.identifire = identifire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
