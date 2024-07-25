package com.oke.league.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oke.league.jpa.Player;
import com.oke.league.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	
	public List<Player> listPlayers() {
		return this.playerRepository.findAll();
	}
	
	public Optional<Player> findByFullName(String fullName){
		return this.playerRepository.findByFullName(fullName);
	}
}
