package com.CRUD.BCCI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.BCCI.entity.BCCISeries;

@Repository
public interface SeriesRepository extends JpaRepository<BCCISeries, Integer> {
	
}