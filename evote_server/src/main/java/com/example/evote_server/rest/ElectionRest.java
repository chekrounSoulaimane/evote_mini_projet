package com.example.evote_server.rest;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.evote_server.bean.Election;
import com.example.evote_server.service.ElectionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/evote/api/election")
public class ElectionRest {

	@Autowired
	private ElectionService electionService;

	@PostMapping(value = "/")
	public Election save(@RequestParam("name") String name, @RequestParam("startDate") String startDateAsString,
			@RequestParam("endDate") String endDateAsString) throws RemoteException {
		Date startDate, endDate;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			startDate = format.parse(startDateAsString);
			endDate = format.parse(endDateAsString);
		} catch (ParseException pe) {
			throw new IllegalArgumentException(pe);
		}
		Election election = new Election(name, startDate, endDate);
		return electionService.save(election);
	}

	@GetMapping("/{id}")
	public Election findById(@PathVariable long id) throws RemoteException {
		return electionService.findById(id);
	}

	@GetMapping("/")
	public List<Election> findAll() throws RemoteException {
		return electionService.findAll();
	}

	@PostMapping(value = "/assign/")
	public String assignCandidatToElection(@RequestParam("candidatId") long candidatId,
			@RequestParam("electionId") long electionId) throws RemoteException {
		return electionService.assignCandidatToElection(candidatId, electionId);
	}

}
