/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.rest;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.service.CandidatService;
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
@RequestMapping("/evote/api/candidat")
public class CandidatRest {

    @Autowired
    private CandidatService candidatService;

    @PostMapping(value = "/")
    public Candidat save(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName, @RequestParam("electionId") long electionId) throws RemoteException {
        Candidat candidat = new Candidat(firstName, secondName);
        return candidatService.save(candidat, electionId);
    }

    @GetMapping("/{id}")
    public Candidat findById(@PathVariable long id) throws RemoteException {
        return candidatService.findById(id);
    }
    
    @GetMapping("/")
    public List<Candidat> findAll() throws RemoteException {
        return candidatService.findAll();
    }

}
