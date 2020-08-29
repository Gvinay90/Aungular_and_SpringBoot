package com.CRUD.BCCI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "BCCISeries")
public class BCCISeries {
	
	@Id
	private int id;
	
	@Column(name = "series_name")
	private String seriesName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "start_date")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	private Date endDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BCCISeries(int id, String seriesName, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.seriesName = seriesName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public BCCISeries() {
		super();
	}
}
