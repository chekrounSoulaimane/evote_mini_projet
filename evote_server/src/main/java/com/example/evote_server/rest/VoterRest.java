/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.rest;

import com.example.evote_server.bean.Voter;
import com.example.evote_server.service.VoterService;
import java.rmi.RemoteException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/evote/api/voter")
public class VoterRest {

    @Autowired
    private VoterService voterService;

    @PostMapping(value = "/")
    public Voter save(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) throws Exception {
        Voter voter = new Voter(firstName, secondName);
        return voterService.save(voter);
    }

    @GetMapping("/{id}")
    public Voter findById(@PathVariable long id) throws RemoteException {
        return voterService.findById(id);
    }
    
    @GetMapping("/")
    public List<Voter> findAll() throws RemoteException {
        return voterService.findAll();
    }

}
