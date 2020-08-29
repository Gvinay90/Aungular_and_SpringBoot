package com.CRUD.BCCI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.BCCI.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
	
}