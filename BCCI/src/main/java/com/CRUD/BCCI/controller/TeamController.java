package com.CRUD.BCCI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.BCCI.Service.TeamService;
import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamService service;
	
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
	
	//Delete Team by ID
	@DeleteMapping("deleteById/{id}")
	public String DeleteTeam(@PathVariable int id) {
		return service.TeamDeleteById(id);
	}
	
	//Update By Id
	@PutMapping("updateById/{id}")
	public Team updateTeamById(@PathVariable int id,@RequestBody Team team) {
		return service.updateTeamById(id, team);
	}
}