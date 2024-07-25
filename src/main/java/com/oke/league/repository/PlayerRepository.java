package com.oke.league.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oke.league.jpa.Player;


public interface PlayerRepository extends JpaRepository<Player, Integer>{

	Optional<Player> findByFullName(String fullName);
}
