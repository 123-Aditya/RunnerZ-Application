package com.freecodecamp.tutorial.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
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
	
//	public List<Run> runs = new ArrayList<>();
//	
//	List<Run> findAll() {
//		return runs;
//	}
//	
//	Optional<Run> findById(Integer id) {
//		return runs.stream()
//				.filter(run -> run.id() == id)
//				.findFirst();
//	}
//	
//	void createRun(Run run) {
//		runs.add(run);
//	}
//	
//	void updateRun(Run updatedRun, Integer id) {
//		Optional<Run> existingRun = findById(id);
//		if(existingRun.isPresent()) {
//			runs.set(runs.indexOf(existingRun.get()), updatedRun);
//		}
//	}
//	
//	void deleteRun(Integer id) {
//		runs.removeIf(run -> run.id().equals(id));
//	}
//	
//	@PostConstruct
//	private void init() {
//		runs.add(new Run(1, "Monday morning run", LocalDateTime.now(), 
//					LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3, Location.OUTDOOR));
//		
//		runs.add(new Run(2, "Wednesday evening run", LocalDateTime.now(), 
//				LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 5, Location.INDOOR));
//	}
	
	
}
