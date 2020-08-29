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

import com.CRUD.BCCI.entity.BCCISeries;

@PropertySource(value = "classpath:sql.properties")
@Repository
public class SeriesJDBCRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${insertSeries}")
	private String insertSeries;
	
	@Value("${deleteSeries}")
	private String deleteSeries;
	
	@Value("${getSeries}")
	private String getSeries;
	
	@Value("${updateSeries}")
	private String updateSeries;
	
	@Value("${getAllSeries}")
	private String getAllSeries;
	
	private static final Logger logger = LoggerFactory.getLogger(SeriesJDBCRepository.class);
	
	class SeriesRowMapper implements RowMapper<BCCISeries> {
		@Override
		public BCCISeries mapRow(ResultSet rs, int rowNum) throws SQLException {
			BCCISeries series = new BCCISeries();
			series.setId(rs.getInt("id"));
			series.setSeriesName(rs.getString("series_name"));
			series.setStartDate(rs.getDate("start_date"));
			series.setEndDate(rs.getDate("end_date"));
			return series;
		}
	}
	//Insert
	public String insertSeries(BCCISeries series) {
		jdbcTemplate.update(insertSeries, new Object[] {
			series.getSeriesName(),series.getStartDate(),series.getEndDate()	
			});
		logger.info("Series Created");
		return "Series Inserted";
	}
	//Update
	public String updateSeries(BCCISeries series,int id) {
		jdbcTemplate.update(updateSeries, new Object[] {
			 series.getSeriesName(), series.getStartDate(), series.getEndDate(), id
			});
		logger.info("updated the id");
		return "Updated Series at" + id;
		}
	//Delete
	public String deleteByid(int id) {
		jdbcTemplate.update(deleteSeries, new Object[] { id });
		logger.info("Deleted id " + id + "Successfully");
		return "Deleted Successfully";
	}
	//Get
	public Optional<BCCISeries> getSeriesByID(int id) {
		try {
			Optional<BCCISeries> series = Optional.of(jdbcTemplate.queryForObject(getSeries, new Object[] { id },
				new BeanPropertyRowMapper<BCCISeries>(BCCISeries.class)));
			 logger.info("Retrived the data");
			 return series;
		} catch (Exception e) {
			logger.warn("Id not exist");
			return Optional.empty();
		}
	}
	//Get all
	public List<BCCISeries> getAllSeries() {
		List<BCCISeries> series = jdbcTemplate.query(getAllSeries, new SeriesRowMapper());
		logger.info("All Series returned");
		return series;
	}
}