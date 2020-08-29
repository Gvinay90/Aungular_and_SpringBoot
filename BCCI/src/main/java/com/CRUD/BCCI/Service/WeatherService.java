package com.CRUD.BCCI.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	public String getData() throws Exception {
        //API key from openweathermap
		String aPI_KEYString = "YOUR_API_KEY";
		String uRLString = "http://api.openweathermap.org/data/2.5/forecast?q=Nashik&units=metric&appid="+aPI_KEYString;
		StringBuilder resultBuilder = new StringBuilder();
		URL url = new URL(uRLString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while((inputLine = bReader.readLine()) != null) {
			resultBuilder.append(inputLine);
		}
		bReader.close();
		logger.info("Weather API Called");
		return resultBuilder.toString();
	}
}