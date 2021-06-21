/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.service;

import com.example.evote_server.bean.Candidat;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CandidatService {

    public Candidat save(Candidat candidat, long electionId);

    public Candidat findById(long id);

    public List<Candidat> findAll();

    public Candidat update(Candidat candidat);

    public void delete(Candidat candidat);
    
    public List<Candidat> findByElection(long electionId);
    
}
