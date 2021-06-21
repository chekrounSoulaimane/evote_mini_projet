/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.serviceImpl;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Vote;
import com.example.evote_server.bean.Voter;
import com.example.evote_server.dao.VoteDao;
import com.example.evote_server.service.CandidatService;
import com.example.evote_server.service.VoteService;
import com.example.evote_server.service.VoterService;
import com.example.evote_server.utils.DigitalSignature;
import java.security.PublicKey;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao voteDao;
    @Autowired
    private VoterService voterService;
    @Autowired
    private CandidatService candidatService;

    @Override
    public Vote save(Vote vote) {
        return voteDao.save(vote);
    }

    @Override
    public Vote findById(long id) {
        return voteDao.findById(id).get();
    }

    @Override
    public List<Vote> findAll() {
        return voteDao.findAll();
    }

    @Override
    public Vote update(Vote vote) {
        return voteDao.save(vote);
    }

    @Override
    public void delete(Vote vote) {
        voteDao.delete(vote);
    }

    @Override
    public String vote(long voterId, long candidatId, PublicKey publicKey, String message, byte[] signature) {
        try {
            
            Candidat candidat = candidatService.findById(candidatId);
            
            Voter voter = voterService.findById(voterId);
            if (voter.isVoted()) {
                return "Desolé, Vous avez deja voté.";
            }
            
            
            boolean correct = DigitalSignature.verifyDigitalSignature(message.getBytes(), signature, publicKey);
            if (!correct) {
                return "Erreur lors de la reception de la signature.";
            }
            
            Vote vote = new Vote(candidatId, voterId, signature);
            
            save(vote);
            
            candidat.setVotesCount(candidat.getVotesCount() + 1);
            candidatService.update(candidat);
            
            voter.setVoted(true);
            voterService.update(voter);

            return "Votre vote a été completé avec succés.";

        } catch (Exception ex) { 
            Logger.getLogger(VoteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
