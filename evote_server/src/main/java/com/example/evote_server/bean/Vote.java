/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lenovo
 */
@SuppressWarnings("serial")
@Entity
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long candidatId;
    private long voterId;
    @Column(columnDefinition = "longblob")
    private byte[] signature;

    public Vote() {
    }

    public Vote(long candidatId, long voterId, byte[] signature) {
        this.candidatId = candidatId;
        this.voterId = voterId;
        this.signature = signature;
    }

    public Vote(long id, long candidatId, long voterId, byte[] signature) {
        this.id = id;
        this.candidatId = candidatId;
        this.voterId = voterId;
        this.signature = signature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(long candidatId) {
        this.candidatId = candidatId;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public long getVoterId() {
        return voterId;
    }

    public void setVoterId(long voterId) {
        this.voterId = voterId;
    }

}
