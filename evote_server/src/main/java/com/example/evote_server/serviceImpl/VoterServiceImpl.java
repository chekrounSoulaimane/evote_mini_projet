/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server.serviceImpl;

import com.example.evote_server.bean.Voter;
import com.example.evote_server.dao.VoterDao;
import com.example.evote_server.service.VoterService;
import com.example.evote_server.utils.DigitalSignature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterDao voterDao;

    private final String folderPath = "C:/Users/Lenovo/Documents/IRISI_4/test/";

    public VoterServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Voter save(Voter voter) {
        System.out.println("haa l fonction asiidi");
        if (voterDao == null) {
            System.out.println("null am3elem");
        }
        Voter savedVoter = voterDao.save(voter);
        String path = folderPath + savedVoter.getId();
        try {
            Files.createDirectories(Paths.get(path));
            KeyPair keyPair = DigitalSignature.generateRSAKeyPair();
            DigitalSignature.SaveKeyPair(path, keyPair);
            savedVoter.setKeyPair(keyPair);
        } catch (Exception ex) {
            Logger.getLogger(VoterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savedVoter;
    }

    @Override
    public Voter findById(long id) {
        Optional<Voter> optional = voterDao.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        Voter voter = optional.get();
        String path = folderPath + voter.getId();
        System.out.println("haa l path asiidi" + path);
        try {
            KeyPair keyPair = DigitalSignature.LoadKeyPair(path);
            voter.setKeyPair(keyPair);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(VoterServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voter;
    }

    @Override
    public List<Voter> findAll() {
        return voterDao.findAll();
    }

    @Override
    public Voter update(Voter voter) {
        return voterDao.save(voter);
    }

    @Override
    public void delete(Voter voter) {
        voterDao.delete(voter);
    }

}
