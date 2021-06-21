package com.example.evote_server.service;

import java.util.List;

import com.example.evote_server.bean.Election;

public interface ElectionService {

    public Election save(Election election);

    public Election findById(long id);

    public List<Election> findAll();

    public Election update(Election election);

    public void delete(Election election);

    public String assignCandidatToElection(long candidatId, long electionId);

}
