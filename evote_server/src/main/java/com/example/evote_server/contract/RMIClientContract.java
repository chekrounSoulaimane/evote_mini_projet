/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.contract;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;
import com.example.evote_server.bean.Voter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface RMIClientContract extends Remote {
    
    public Voter createVoter(String firstName, String secondName) throws RemoteException;
    
    public List<Election> findAllElections() throws RemoteException;
    
    public List<Candidat> findCandidatsByElection(long electionId) throws RemoteException;
    
    public String vote(Voter voter, long candidatId, String message) throws RemoteException, Exception;
}
