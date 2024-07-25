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

import com.oke.league.jpa.Player;
import com.oke.league.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("/test")
	public String testController() {
		logger.debug("The testController() method was invoked");
		return "The League app is up and running";
	}
	
	@GetMapping("/")
	public List<Player> listPlayers() {
		logger.debug("The listPlayers() method was invoked!");
		return this.playerService.listPlayers();
	}
	
	
	@GetMapping("/{fullName}")
	public Optional<Player> findByFullName(@PathVariable String fullName) {
		logger.debug("The findByFirstName() method was invoked!, username={}", fullName);
		return this.playerService.findByFullName(fullName);
	}
}
