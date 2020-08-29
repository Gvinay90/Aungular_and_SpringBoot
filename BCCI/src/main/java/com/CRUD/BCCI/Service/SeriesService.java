package com.CRUD.BCCI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CRUD.BCCI.entity.BCCISeries;
import com.CRUD.BCCI.exception.ResourceNotFoundException;
import com.CRUD.BCCI.repository.SeriesRepository;

@Service
public class SeriesService {
	
	@Autowired
	private SeriesRepository seriesRepository;
	
	public String saveSeries(BCCISeries series) {
		seriesRepository.save(series);
		return "Team Data Inserted for tema id " + series.getId();
	}
	
	public ResponseEntity<BCCISeries> getSeriesById(int id)
			throws ResourceNotFoundException {
		BCCISeries series = seriesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Series not found for this id :: " +  id));
		return ResponseEntity.ok().body(series);
	}

	public String SeriesDeleteById(int id) {
		seriesRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public BCCISeries updateSeriesById(int id,BCCISeries series) {
		BCCISeries series1 = seriesRepository.findById(id).orElse(null);
		series1.setSeriesName(series.getSeriesName());
		series1.setStartDate(series.getStartDate());
		series1.setEndDate(series.getEndDate());
		return seriesRepository.save(series1);
		
	}
}
