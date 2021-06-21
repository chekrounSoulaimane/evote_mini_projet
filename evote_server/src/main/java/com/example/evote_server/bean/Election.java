package com.example.evote_server.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Election implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Date startDate;
	private Date endDate;
    @OneToMany(mappedBy = "election")
	private List<Candidat> candidats;

	public Election() {
	}

	public Election(String name, Date startDate, Date endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.candidats = new ArrayList<Candidat>();
	}

	public Election(long id, String name, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.candidats = new ArrayList<Candidat>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    @JsonIgnore
	public List<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}

	@Override
	public String toString() {
		return "Election " + id + ": name=" + name + ", startDate=" + startDate + ", endDate=" + endDate;
	}

}
