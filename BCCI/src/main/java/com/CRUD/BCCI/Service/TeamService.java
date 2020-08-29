package com.CRUD.BCCI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.exception.ResourceNotFoundException;
import com.CRUD.BCCI.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public String saveTeam(Team team) {
		teamRepository.save(team);
		return "Team Data Inserted for tema id " + team.getId();
	}
	
	public ResponseEntity<Team> getTeamById(int id)
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " +  id));
		return ResponseEntity.ok().body(team);
	}

	public String TeamDeleteById(int id) {
		teamRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public Team updateTeamById(int id,Team team) {
		Team team1 = teamRepository.findById(id).orElse(null);
		team1.setTeamName(team.getTeamName());
		team1.setId(team.getId());
		team1.setSeriesName(team.getSeriesName());
		team1.setDateOfMatch(team.getDateOfMatch());
		return teamRepository.save(team1);
		
	}
		
}
