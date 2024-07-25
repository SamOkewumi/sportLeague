package com.oke.league.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oke.league.jpa.Team;
import com.oke.league.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TeamService teamService;

	@GetMapping({"/"})
	public List<Team> findAllTeams(){
		logger.debug("The findAllTeams() method was invoked.");
		return this.teamService.listTeams();
	}

	@GetMapping("/{name}")
	public Optional<Team> findByName(@PathVariable String name){
		logger.debug("The findByName() method was invoked!, teamName={}", name);
		return this.teamService.findByName(name);
	}

}
