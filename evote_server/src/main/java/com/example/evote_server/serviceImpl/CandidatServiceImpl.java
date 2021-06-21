/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.serviceImpl;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;
import com.example.evote_server.dao.CandidatDao;
import com.example.evote_server.service.CandidatService;
import com.example.evote_server.service.ElectionService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatDao candidatDao;
    @Autowired
    private ElectionService electionService;

    @Override
    public Candidat save(Candidat candidat, long electionId) {
    	Election election = electionService.findById(electionId);
    	candidat.setElection(election);
        return candidatDao.save(candidat);
    }

    @Override
    public Candidat findById(long id) {
        Optional<Candidat> optional = candidatDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Candidat> findAll() {
        return candidatDao.findAll();
    }

    @Override
    public Candidat update(Candidat candidat) {
        return candidatDao.save(candidat);
    }

    @Override
    public void delete(Candidat candidat) {
        candidatDao.delete(candidat);
    }

	@Override
	public List<Candidat> findByElection(long electionId) {
    	Election election = electionService.findById(electionId);
    	if (election == null)
    		return null;
    	
		return candidatDao.findByElection(election);
	}

}
