package com.CRUD.BCCI.controller;
/*
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.CRUD.BCCI.Service.TeamService;
import com.CRUD.BCCI.entity.BCCISeries;
import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.exception.ResourceNotFoundException;
import com.CRUD.BCCI.repository.SeriesRepository;
import com.CRUD.BCCI.repository.TeamRepository;
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

	/*
	@Autowired
	private SeriesRepository seriesRepository;
	@Autowired
	private TeamRepository teamRepository;
	*/
/*
	@Autowired
	private TeamService service;
	
	/*
	//Insert Series
	@PostMapping("/createSeries")
	public BCCISeries createBcciSeries(@RequestBody BCCISeries series) {
		return seriesRepository.save(series);
	}
	*/
	/*
	//Insert Team
	@PostMapping("/registerTeam")
	public String registerTeam(@RequestBody Team team) {
		return service.saveTeam(team);
	}
	
	//Get Team
	@GetMapping("/getTeamById/{id}")
	public ResponseEntity<Team> TeamById(@PathVariable int id ) throws ResourceNotFoundException {
		return service.getTeamById(id);
	}
	*/
	
	//Delete by id
	
	/*
	//Get Series
	@GetMapping("/getSeriesById/{id}")
	public ResponseEntity<BCCISeries> getSeriesById(@PathVariable(value = "id") int SeriesId)
			throws ResourceNotFoundException {
		BCCISeries series = seriesRepository.findById(SeriesId).orElseThrow(() -> new ResourceNotFoundException("Series not found for this id :: " + SeriesId));
		return ResponseEntity.ok().body(series);
	}
	
	//Get all series
	@GetMapping("/Series")
	public List<BCCISeries> getAllSeries() {
		return seriesRepository.findAll();
	}
	
	//Get all team
	@GetMapping("/Teams")
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}
	
	
	
	//delete Series
	@DeleteMapping("/deleteSeriesbyId/{id}")
	public Map<String, Boolean> deleteSeries(@PathVariable(value = "id") int SeriesId)
			throws ResourceNotFoundException {
		BCCISeries series = seriesRepository.findById(SeriesId)
				.orElseThrow(() -> new ResourceNotFoundException("Series not found for this id :: " + SeriesId));

		seriesRepository.delete(series);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	//delete Team
	@DeleteMapping("/deleteTeambyId/{id}")
	public Map<String, Boolean> deleteTeam(@PathVariable(value = "id") int teamId)
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " +  teamId));

		teamRepository.delete(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	//update series
	@PutMapping("/updateSeries/{id}")
	public Map<String, Boolean> updateSeries(@PathVariable(value = "id") int seriesId , @RequestBody BCCISeries seriesDetail)
			throws ResourceNotFoundException {
		BCCISeries series = seriesRepository.findById(seriesId)
				.orElseThrow(() -> new ResourceNotFoundException("Series not found for this id :: " + seriesId));

		series.setSeriesName(seriesDetail.getSeriesName());
		series.setStartDate(seriesDetail.getStartDate());
		series.setEndDate(seriesDetail.getEndDate());
		final BCCISeries updatedSeries = seriesRepository.save(series);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return response;
	}
	
	//update team
	@PutMapping("/updateTeam/{id}")
	public Map<String, Boolean> updateTeam(@PathVariable(value = "id") int TeamId , @RequestBody Team teamDetail)
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(TeamId)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + TeamId));
		
		team.setTeamName(teamDetail.getTeamName());
		team.setDateOfMatch(teamDetail.getDateOfMatch());
		team.setSeriesName(teamDetail.getSeriesName());
		final Team updatedTeam = teamRepository.save(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return response;
	}
	*/
	
}