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

import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.exception.ResourceNotFoundException;
import com.CRUD.BCCI.repository.TeamJDBCRepository;


@RestController
@RequestMapping("api/jdbc/team")
public class JDBCTeamController {
	@Autowired
	private TeamJDBCRepository teamJDBCRepository;
	
	@PostMapping
	public String Insert(@RequestBody Team team) {
		return teamJDBCRepository.insertJdbc(team);
	}
	
	@GetMapping("/{id}")
	public Optional<Team> getById(@PathVariable int id) {
		return teamJDBCRepository.getTeamByID(id);
	}
	
	@GetMapping
	public List<Team> getAllTeam() {
		return teamJDBCRepository.getAllTeam();
	}
	
	@GetMapping("/name/{seriesName}")
	public List<Team> getTeamBySeriesName(@PathVariable String seriesName) throws ResourceNotFoundException {
		return teamJDBCRepository.getTeamBySeriesName(seriesName);
	}
	
	@PutMapping("/{id}")
	public String updateById(@RequestBody Team team,@PathVariable int id) {
		return teamJDBCRepository.update(team,id);
	}
	
	@DeleteMapping("/{id}")
	public String DeleteTeam(@PathVariable int id) {
		return teamJDBCRepository.deleteByid(id);
	}
	
	@DeleteMapping("/name/{seriesName}")
	public String deleteBySeriesName(@PathVariable String seriesName) throws ResourceNotFoundException {
		return teamJDBCRepository.deteleBySeriesName(seriesName);
	}
}