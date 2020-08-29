package com.CRUD.BCCI.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.exception.ResourceNotFoundException;

@PropertySource(value = "classpath:sql.properties")
@Repository
public class TeamJDBCRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${getAllTeam}")
	private String getAllTeams;
	
	@Value("${insertTeam}")
	private String insertTeam;
	
	@Value("${updateTeam}")
	private String updateTeam;
	
	@Value("${deleteTeam}")
	private String deleteTeam;
	
	@Value("${getTeam}")
	private String getTeam;
	
	@Value("${getSeriesByName}")
	private String getSeriesByName;
	
	@Value("${getBySeriesName}")
	private String getBySeriesName;
	
	@Value("${deleteBySeriesName}")
	private String deleteBySeriesName;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamJDBCRepository.class);
	
	class TeamRowMapper implements RowMapper<Team> {
		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setId(rs.getInt("id"));
			team.setTeamName(rs.getString("team_name"));
			team.setSeriesName(rs.getString("series_name"));
			team.setDateOfMatch(rs.getDate("date_of_match"));
			return team;
		}
	}
	//Insert
	public String insertJdbc(Team team) {
		try {
				jdbcTemplate.queryForObject( getSeriesByName, new Object[] {
					team.getSeriesName()
				},
					new BeanPropertyRowMapper<Team>(Team.class));
					jdbcTemplate.update(insertTeam, new Object[] {
						team.getId(),team.getTeamName(),team.getSeriesName(),team.getDateOfMatch()	
						});
				logger.info("Entry Recived");
				return "Inserted Team at " + team.getId();
		} catch (Exception e) {
			logger.warn("Series not found");
			return "Series not exist";
		}
			
	}
	//Update
	public String update(Team team,int id) {
		jdbcTemplate.update(updateTeam, new Object[] {
			team.getId(), team.getTeamName(), team.getSeriesName(), team.getDateOfMatch(), id
			});
		logger.info("updated the id");
		return "Updated Team at" + id;
	}
	//Delete
	public String deleteByid(int id) {
		jdbcTemplate.update(deleteTeam, new Object[] { id });
		logger.info("Deleted id " + id + "Successfully");
		return "Deleted Successfully";
	}
	//Get
	public Optional<Team> getTeamByID(int id) {
		try {
			 Optional<Team> team = Optional.of(jdbcTemplate.queryForObject(getTeam, new Object[] { id },
				new BeanPropertyRowMapper<Team>(Team.class)));
			 logger.info("Retrived the data");
			 return team;
		} catch (Exception e) {
			logger.warn("Id not exist");
			return Optional.empty();
		}
	}
	//Get all
	public List<Team> getAllTeam() {
		List<Team> teams = jdbcTemplate.query(getAllTeams, new TeamRowMapper());
		logger.info("All team returned");
		return teams;
	}
	//Get Team by series name
	public List<Team> getTeamBySeriesName(String name) throws ResourceNotFoundException {
		List<Team> team = jdbcTemplate.query(getBySeriesName, new Object[] { name },
				new TeamRowMapper());
		logger.info("Team by series retrived"+ team);
		return team;
	}
	//Delete Team by series Name
	public String deteleBySeriesName(String name) throws ResourceNotFoundException {
		jdbcTemplate.update(deleteBySeriesName, new Object[] { name });
		return "Delete team for series " + name; 
		
	}
	
}
