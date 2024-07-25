package com.oke.league.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oke.league.jpa.Team;
import com.oke.league.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;

	public List<Team> listTeams(){
		return this.teamRepository.findAll();
	}

	public Optional<Team> findByName(String name){
		return this.teamRepository.findByName(name);

	}

}
