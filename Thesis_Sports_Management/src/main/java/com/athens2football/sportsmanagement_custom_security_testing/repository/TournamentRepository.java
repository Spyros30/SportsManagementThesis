package com.athens2football.sportsmanagement_custom_security_testing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Tournament;

@Repository("tournamentRepository")
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

		public List<Tournament> findAllByOrderByCityAsc();
}
