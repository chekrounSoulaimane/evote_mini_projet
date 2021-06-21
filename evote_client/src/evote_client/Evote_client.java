/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evote_client;

import com.example.evote_server.bean.Candidat;
import com.example.evote_server.bean.Election;
import com.example.evote_server.bean.Voter;
import com.example.evote_server.contract.RMIClientContract;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Evote_client {

    private static Scanner scanner;

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "rmi://localhost/client_services";
        try {
        	System.out.println("Application started succesffully :");
            RMIClientContract rmiClientContract = (RMIClientContract) Naming.lookup(url);
            scanner = new Scanner(System.in);
        	System.out.println("Please enter your");
        	System.out.print("First name: ");
            String firstName = scanner.next();
        	System.out.println("");
        	System.out.print("Second name: ");
            String secondName = scanner.next();
            Voter voter = rmiClientContract.createVoter(firstName, secondName);
            System.out.println("Votre compte a ete cree avec succes.\n\n");
            
            List<Election> elections = rmiClientContract.findAllElections();
            elections.forEach(election -> {
                System.out.println(election.toString());
            });
        	System.out.print("\nVoila les elections courant.\nVeuillez choisir une: ");
            long choosedElection = scanner.nextLong();
            
            List<Candidat> candidats = rmiClientContract.findCandidatsByElection(choosedElection);
            candidats.forEach(candidat -> {
                System.out.println(candidat.toString());
            });
            System.out.print("\nPour vote entre le numero du candidat que vous voulez voter pour :");
            long choosedCandidat = scanner.nextLong();
            String result = rmiClientContract.vote(voter, choosedCandidat, "message of client");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
