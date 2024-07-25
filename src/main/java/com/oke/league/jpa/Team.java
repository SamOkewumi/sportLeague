package com.oke.league.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"Teams\"")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"team_id\"")
	private Integer teamId;

	@Column(name="\"name\"")
	private String name;
	
	@Column(name="\"division_id\"")
	private Integer divisionId;
	
	@Column(name="\"logo_url\"", columnDefinition="character varying default 'https://cdn.pixabay.com/photo/2017/03/16/21/18/logo-2150297_1280.png'")
	private String logoUrl;
	
	@Column(columnDefinition="int default 0")
	private Integer wins;
	
	@Column(columnDefinition="int default 0")
	private Integer losses;
	
	@Column(columnDefinition="int default 0")
	private Integer ties;
	
	@Column(name="\"games_played\"", columnDefinition="int default 0")
	private Integer gamesPlayed;
	
	private Integer points;
	
	@Column(name="\"goals_for\"", columnDefinition="int default 0")
	private Integer goalsFor;
	
	@Column(name="\"goals_against\"", columnDefinition="int default 0")
	private Integer goalsAgainst;
	
	@Column(name="\"goal_difference\"", columnDefinition="int default 0")
	private Integer goalDifference;
	
	@Column(name="\"win_percentage\"")
	private BigDecimal winPercentage;
	
	@Column(name="\"division_name\"")
	private String divisionName;
	
	public Team() {}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Integer getTies() {
		return ties;
	}

	public void setTies(Integer ties) {
		this.ties = ties;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(Integer goalsFor) {
		this.goalsFor = goalsFor;
	}

	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public Integer getGoalDifference() {
		return goalDifference;
	}

	public void setGoalDifference(Integer goalDifference) {
		this.goalDifference = goalDifference;
	}

	public BigDecimal getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(BigDecimal winPercentage) {
		this.winPercentage = winPercentage;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", divisionId=" + divisionId + ", logoUrl=" + logoUrl
				+ ", wins=" + wins + ", losses=" + losses + ", ties=" + ties + ", gamesPlayed=" + gamesPlayed
				+ ", points=" + points + ", goalsFor=" + goalsFor + ", goalsAgainst=" + goalsAgainst
				+ ", goalDifference=" + goalDifference + ", winPercentage=" + winPercentage + ", divisionName="
				+ divisionName + "]";
	}
	
	
	
	
}
