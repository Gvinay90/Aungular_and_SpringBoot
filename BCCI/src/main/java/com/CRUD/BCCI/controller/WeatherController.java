package com.CRUD.BCCI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.BCCI.Service.WeatherService;

@RestController
@RequestMapping("api/weather")
public class WeatherController {
	@Autowired
	private WeatherService service;
	
	@GetMapping
	public String getWeather() throws Exception {
		return service.getData();
	}
}