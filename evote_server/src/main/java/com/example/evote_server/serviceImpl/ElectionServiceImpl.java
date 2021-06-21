/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.serviceImpl;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;
import com.example.evote_server.dao.ElectionDao;
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
public class ElectionServiceImpl implements ElectionService {

    @Autowired
    private ElectionDao electionDao;
    @Autowired
    private CandidatService candidatService;

    @Override
    public Election save(Election election) {
        return electionDao.save(election);
    }

    @Override
    public Election findById(long id) {
        Optional<Election> optional = electionDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Election> findAll() {
        return electionDao.findAll();
    }

    @Override
    public Election update(Election election) {
        return electionDao.save(election);
    }

    @Override
    public void delete(Election election) {
        electionDao.delete(election);
    }

	@Override
	public String assignCandidatToElection(long candidatId, long electionId) {
		Election election = findById(electionId);
		if (election == null)
			return "election was not found";
		
		Candidat candidat = candidatService.findById(candidatId);
		if (candidat == null)
			return "candidat was not found";
		
		election.getCandidats().add(candidat);
		update(election);
		return "candidat added successfully";
	}

}
