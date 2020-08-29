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

import com.CRUD.BCCI.Service.SeriesService;
import com.CRUD.BCCI.entity.BCCISeries;
import com.CRUD.BCCI.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/series")
public class SeriesController {
	@Autowired
	SeriesService service;
	
	//Insert Team
	@PostMapping("/registerSeries")
	public String registerTeam(@RequestBody BCCISeries series) {
		
		return service.saveSeries(series);
	}
		
	//Get Team
	@GetMapping("/getSeriesById/{id}")
	public ResponseEntity<BCCISeries> SeriesById(@PathVariable int id ) throws ResourceNotFoundException {
		return service.getSeriesById(id);
	}
	
	//Delete Team by ID
	@DeleteMapping("deleteById/{id}")
	public String DeleteSeries(@PathVariable int id) {
		return service.SeriesDeleteById(id);
	}
	
	//Update By Id
	@PutMapping("updateById/{id}")
	public BCCISeries updateSeriesById(@PathVariable int id,@RequestBody BCCISeries series) {
		return service.updateSeriesById(id, series);
	}
}
