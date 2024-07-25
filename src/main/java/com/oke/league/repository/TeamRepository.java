package com.oke.league.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oke.league.jpa.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	Optional<Team> findByName(String name);

}
