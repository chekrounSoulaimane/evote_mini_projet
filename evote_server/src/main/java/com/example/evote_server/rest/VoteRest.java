/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.rest;

import com.example.evote_server.bean.Voter;
import com.example.evote_server.service.VoteService;
import com.example.evote_server.service.VoterService;
import com.example.evote_server.utils.DigitalSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/evote/api/vote")
public class VoteRest {

    @Autowired
    private VoteService voteService;
    @Autowired
    private VoterService voterService;

    @PostMapping(value = "/")
    public String vote(@RequestParam("message") String message) throws Exception {
        Voter voter = voterService.findById(2);
        byte[] signutare = DigitalSignature.createDigitalSignature(message.getBytes(), voter.getKeyPair().getPrivate());
        return voteService.vote(2, 1, voter.getKeyPair().getPublic(), message, signutare);
    }
}
