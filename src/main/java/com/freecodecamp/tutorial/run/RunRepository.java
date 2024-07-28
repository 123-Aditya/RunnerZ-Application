package com.freecodecamp.tutorial.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Repository
public class RunRepository {

	private static final Logger LOG = LoggerFactory.getLogger(RunRepository.class);
	private final JdbcClient jdbcClient;
	
	public RunRepository(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	public List<Run> findAll() {
	return jdbcClient.sql("select * from run")
			.query(Run.class)
			.list();
	}
	
	Optional<Run> findById(Integer id) {
		return jdbcClient.sql("SELECT * FROM Run WHERE id = :id")
				.param("id", id)
				.query(Run.class)
				.optional();
	}
	
	void createRun(Run run) {
		var updated = jdbcClient.sql("INSERT INTO Run(id, title, started_on, completed_on, miles, location) values (?,?,?,?,?,?)")
				.params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
				.update();
		
		Assert.state(updated == 1, "Failed to create run: " + run.title());
	}
	
	void updateRun(Run run, Integer id) {
		var updated = jdbcClient.sql("update run set title=?, started_on=?, completed_on=?, miles=?, location=? where id=?")
				.params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
				.update();
		
		Assert.state(updated == 1, "Failed to update run: " + run.title());
	}
	
	void deleteRun(Integer id) {
		var updated = jdbcClient.sql("DELETE FROM Run WHERE id = :id")
				.param("id", id)
				.update();
		
		Assert.state(updated == 1, "Failed to delete run: " + id);
	}
	
	public int count() {
		return jdbcClient.sql("select * from run")
				.query()
				.listOfRows()
				.size();
	}
	
	public void saveAll(List<Run> runs) {
		runs.stream().forEach(this::createRun);
	}
	
	public List<Run> findByLocation(String location) {
		return jdbcClient.sql("select * from run where location = :location")
				.param("location",location)
				.query(Run.class)
				.list();
	}
	
	
//	@PostConstruct
//	private void init() {
//		runs.add(new Run(1, "Monday morning run", LocalDateTime.now(), 
//					LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3, Location.OUTDOOR));
//		
//		runs.add(new Run(2, "Wednesday evening run", LocalDateTime.now(), 
//				LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 5, Location.INDOOR));
//	}
	
	
}
