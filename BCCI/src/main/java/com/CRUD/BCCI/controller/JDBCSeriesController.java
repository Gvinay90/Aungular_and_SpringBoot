package com.CRUD.BCCI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.BCCI.entity.BCCISeries;
import com.CRUD.BCCI.repository.SeriesJDBCRepository;

@RestController
@RequestMapping("api/jdbc/series")
public class JDBCSeriesController {
	
	@Autowired
	SeriesJDBCRepository seriesRepository;
	
	@PostMapping
	public String Insert(@RequestBody BCCISeries series) {
		return seriesRepository.insertSeries(series);
	}
	
	@GetMapping("/{id}")
	public Optional<BCCISeries> getById(@PathVariable int id) {
		return seriesRepository.getSeriesByID(id);
	}
	@GetMapping
	public List<BCCISeries> getAllSeries() {
		return seriesRepository.getAllSeries();
	}
	@PutMapping("/{id}")
	public String updateById(@RequestBody BCCISeries series, @PathVariable int id) {
		return seriesRepository.updateSeries(series, id);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteTeam(@PathVariable int id) {
		return seriesRepository.deleteByid(id);
	}
}
