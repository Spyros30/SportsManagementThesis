package com.athens2football.sportsmanagement_custom_security_testing.service;

import java.util.List;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Team;
import com.athens2football.sportsmanagement_custom_security_testing.entity.Tournament;
import com.athens2football.sportsmanagement_custom_security_testing.entity.User;


public interface SportsManagementService {
	
	public List<Tournament> findAllTournaments();
	
	public Tournament findById(int theId);
	
	public Tournament findByTournamentId(int tournamentId);
	
	public void save(Tournament theTournament);
	
	public void deleteById(int theId);

	public void save(Team theTeam);
	
	public User findByUserId(int userId);
}
