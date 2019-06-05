package com.athens2football.sportsmanagement_custom_security_testing.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "shirt_color")
	private String shirtColor;
	
	@Column(name = "number_of_players")
	private int numberOfPlayers;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
	name="tournament_teams",
	joinColumns=@JoinColumn(name="team_id"),
	inverseJoinColumns=@JoinColumn(name="tournament_id")
	)
	private List<Tournament> tournaments;
	
}







