package com.athens2football.sportsmanagement_custom_security_testing.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tournament")
public class Tournament {
	
	// define fields 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tournament_id")
	private int tournamentId;
	
	@Column(name="tournament_name")
	private String tournamentName;
	
	@Column(name="stadium_name")
	private String stadiumName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="reward")
	private String reward;
	
	@Column(name="date_start")
	private String dateStart;
	
	@Column(name="number_of_teams")
	private int numberOfTeams;

	@ManyToMany
	@JoinTable(
		name="tournament_teams",
		joinColumns=@JoinColumn(name="tournament_id"),
		inverseJoinColumns=@JoinColumn(name="team_id")
		)
	private List<Team> teams;
	
}









