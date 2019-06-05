package com.athens2football.sportsmanagement_custom_security_testing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Team;
import com.athens2football.sportsmanagement_custom_security_testing.entity.Tournament;
import com.athens2football.sportsmanagement_custom_security_testing.entity.User;
import com.athens2football.sportsmanagement_custom_security_testing.repository.TeamRepository;
import com.athens2football.sportsmanagement_custom_security_testing.repository.TournamentRepository;
import com.athens2football.sportsmanagement_custom_security_testing.repository.UserTeamRepository;


@Service
public class SportsManagementServiceImpl implements SportsManagementService {
	
	private TeamRepository teamRepository;
	private TournamentRepository tournamentRepository;
    private UserTeamRepository userTeamRepository;
	
	@Autowired
    public SportsManagementServiceImpl(
                       TeamRepository theTeamRepository, TournamentRepository theTournamentRepository, UserTeamRepository theUserTeamRepository) {
		teamRepository = theTeamRepository;
		tournamentRepository = theTournamentRepository;
		userTeamRepository = theUserTeamRepository;
        
    }
	
	@Override
	public List<Tournament> findAllTournaments() {
		return tournamentRepository.findAllByOrderByCityAsc();
	}
	
	@Override
	public Tournament findByTournamentId(int tournamentId) {
		
		Optional<Tournament> result = tournamentRepository.findById(tournamentId);
		
		Tournament theTournament = null;
		if (result.isPresent())
		{
			theTournament = result.get();
		}
		else {
			// we didn't find the tournament
			throw new RuntimeException("Did not find tournament id - " + tournamentId);
		}
		return theTournament;
	}
	
	@Override
	public Tournament findById(int theId) {
		Optional<Tournament> result = tournamentRepository.findById(theId);
		
		Tournament theTournament = null;
		if (result.isPresent())
		{
			theTournament = result.get();
		}
		else {
			// we didn't find the tournament
			throw new RuntimeException("Did not find tournament id - " + theId);
		}
		return theTournament;
	}

	@Override
	public void save(Tournament theTournament) {
		tournamentRepository.save(theTournament);
	}

	@Override
	public void deleteById(int theId) {
		tournamentRepository.deleteById(theId);
	}

	@Override
	public User findByUserId(int userId) {
		Optional<User> result = userTeamRepository.findById(userId);
		
		User theUser = null;
		if (result.isPresent())
		{
			theUser = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find user id - " + userId);
		}
		
		return theUser;
	}

	@Override
	public void save(Team theTeam){
		teamRepository.save(theTeam);
	}
	
}
