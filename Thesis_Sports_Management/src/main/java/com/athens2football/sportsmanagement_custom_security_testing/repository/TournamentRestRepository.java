package com.athens2football.sportsmanagement_custom_security_testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Tournament;

@RepositoryRestResource(path="tournaments")
public interface TournamentRestRepository extends JpaRepository<Tournament, Integer> {

}
