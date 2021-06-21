/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.contractImpl;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;
import com.example.evote_server.bean.Voter;
import com.example.evote_server.contract.RMIClientContract;
import com.example.evote_server.service.CandidatService;
import com.example.evote_server.service.ElectionService;
import com.example.evote_server.service.VoteService;
import com.example.evote_server.service.VoterService;
import com.example.evote_server.utils.DigitalSignature;
import java.rmi.RemoteException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lenovo
 */
@Component("RMIClientService")
public class RMIClientContractImpl implements RMIClientContract {

	@Autowired
	private CandidatService candidatService;
	@Autowired
	private ElectionService electionService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoterService voterService;

	@Override
	public Voter createVoter(String firstName, String secondName) throws RemoteException {
		System.out.println("RMI client service -> createVoter");
		Voter voter = new Voter(firstName, secondName);
		return voterService.save(voter);
	}

	@Override
	public List<Election> findAllElections() throws RemoteException {
		System.out.println("RMI client service -> findAllElections");
		List<Election> elections = electionService.findAll();
		elections.forEach(election -> {
			election.setCandidats(null);
		});
		return elections;
	}

	@Override
	public List<Candidat> findCandidatsByElection(long electionId) throws RemoteException {
		System.out.println("RMI client service -> findCandidatsByElection");
		List<Candidat> candidats = candidatService.findByElection(electionId);
		candidats.forEach(candidat -> {
			candidat.setElection(null);
		});
		return candidats;
	}

	@Override
	public String vote(Voter voter, long candidatId, String message) throws RemoteException, Exception {
		System.out.println("RMI client service -> findAllCandidats");
		System.out.println("received message -> " + message);
		byte[] signature = DigitalSignature.createDigitalSignature(message.getBytes(), voter.getKeyPair().getPrivate());
		return voteService.vote(voter.getId(), candidatId, voter.getKeyPair().getPublic(), message, signature);
	}
}
