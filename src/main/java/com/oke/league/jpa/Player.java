package com.oke.league.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"Players\"")
public class Player implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"player_id\"")
	private Integer playerId;
	
	@Column(name="\"first_name\"")
	private String firstName;
	
	@Column(name="\"last_name\"")
	private String lastName;
	
	@Column(name="\"full_name\"")
	private String fullName;
	
	
	@Column(name="\"photo_url\"", columnDefinition="character varying default 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png'")
	private String photoUrl;
	
	@Column(name="\"games_played\"", columnDefinition="int default 0")
	private Integer gamesPlayed = 0;
	
	@Column(name="\"goals_scored\"", columnDefinition="int default 0")
	private Integer goalsScored = 0;
	
	@Column(name="\"yellow_cards\"", columnDefinition="int default 0")
	private Integer yellowCards = 0;
	
	@Column(name="\"red_cards\"", columnDefinition="int default 0")
	private Integer redCards = 0;
	
	@Column(name="\"team_name\"")
	private String teamName;
	
	
	public Player() {}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}

	public Integer getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(Integer yellowCards) {
		this.yellowCards = yellowCards;
	}

	public Integer getRedCards() {
		return redCards;
	}

	public void setRedCards(Integer redCards) {
		this.redCards = redCards;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	

//	public Team getTeam() {
//		return team;
//	}
//
//	public void setTeam(Team team) {
//		this.team = team;
//	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", photoUrl="
				+ photoUrl + ", gamesPlayed=" + gamesPlayed + ", goalsScored=" + goalsScored + ", yellowCards="
				+ yellowCards + ", redCards=" + redCards + ", teamName=" + teamName + "]";
	}
	
	
}
