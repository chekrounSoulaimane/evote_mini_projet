/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.dao;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Lenovo
 */
@Repository
@CrossOrigin
public interface CandidatDao extends JpaRepository<Candidat, Long> {

    public List<Candidat> findByElection(Election election);
    
}
