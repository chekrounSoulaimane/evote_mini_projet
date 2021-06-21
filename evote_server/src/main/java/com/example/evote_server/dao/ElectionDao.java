package com.example.evote_server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.evote_server.bean.Election;

@Repository
@CrossOrigin
public interface ElectionDao extends JpaRepository<Election, Long> {

}
