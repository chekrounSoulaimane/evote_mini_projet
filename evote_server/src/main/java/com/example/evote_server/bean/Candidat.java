/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lenovo
 */
@SuppressWarnings("serial")
@Entity
public class Candidat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String secondName;
    private long votesCount;
    @ManyToOne
    private Election election;

    public Candidat() {
    }

    public Candidat(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.votesCount = 0;
    }

    public Candidat(long id, String firstName, String secondName, long votesCount) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.votesCount = votesCount;
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

    public long getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(long votesCount) {
        this.votesCount = votesCount;
    }

    public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	@Override
    public String toString() {
        return "Candidat " + id + ": firstName=" + firstName + ", secondName=" + secondName + ";";
    }

}
