/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.service;

import com.example.evote_server.bean.Vote;
import java.security.PublicKey;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface VoteService {

    public Vote save(Vote vote);

    public Vote findById(long id);

    public List<Vote> findAll();

    public Vote update(Vote vote);

    public void delete(Vote vote);

    public String vote(long voterId, long candidatId, PublicKey publicKey, String message, byte[] signature);

}
