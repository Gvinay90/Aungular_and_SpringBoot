package com.CRUD.BCCI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.CRUD.BCCI.entity.Team;
import com.CRUD.BCCI.repository.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamTest {
	
	@MockBean
	private TeamRepository teamRepository;
	
	@Test
	void testpostTeam() {
		String date = "2020-08-20";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
		try {
			myDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Team team = new Team(1,"IND",myDate,"ICC");
		Mockito.when(teamRepository.save(team)).thenReturn(team);
		assertEquals(teamRepository.save(team), team);
	}
	
	@Test
	void testgetTeam() {
		String date = "2020-08-20";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
		try {
			myDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Team team = new Team(1,"IND",myDate,"ICC");
		Mockito.when(teamRepository.findById(1)).thenReturn(Optional.of(team));
		assertEquals(teamRepository.findById(1), team);
	}
	
	
}