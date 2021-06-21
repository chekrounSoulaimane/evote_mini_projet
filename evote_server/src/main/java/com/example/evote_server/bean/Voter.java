/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.bean;

import java.io.Serializable;
import java.security.KeyPair;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Lenovo
 */
@SuppressWarnings("serial")
@Entity
public class Voter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String secondName;
    private boolean voted;
    @Transient
    private KeyPair keyPair;

    public Voter() {
    }

    public Voter(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.voted = false;
    }

    public Voter(long id, String firstName, String secondName, boolean voted) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.voted = voted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    @Override
    public String toString() {
        return "Voter " + id + ": firstName=" + firstName + ", secondName=" + secondName + ";";
    }

    public KeyPair getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

}
