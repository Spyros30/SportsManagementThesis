package com.athens2football.sportsmanagement_custom_security_testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Team;

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Integer> {

}








