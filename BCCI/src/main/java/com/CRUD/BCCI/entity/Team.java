package com.CRUD.BCCI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "team")
public class Team {
	
	@Id
	private int id;
	@Column(name = "team_name")
	private String teamName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_of_match")
	private Date dateOfMatch;
	
	@Column(name = "series_name")
	private String seriesName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Date getDateOfMatch() {
		return dateOfMatch;
	}
	public void setDateOfMatch(Date dateOfMatch) {
		this.dateOfMatch = dateOfMatch;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	
	public Team() {
		super();
	}
	
	public Team(int id, String teamName, Date dateOfMatch, String seriesName) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.dateOfMatch = dateOfMatch;
		this.seriesName = seriesName;
	}
}