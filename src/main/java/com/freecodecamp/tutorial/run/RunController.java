package com.freecodecamp.tutorial.run;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/runs")
public class RunController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RunController.class);

	public final RunRepository runRepository;
	
	public RunController(RunRepository runRepository) {
		this.runRepository = runRepository;
	}
	
	@GetMapping("/welcome")
	String name() {
		LOG.info("Returning response for /hello mapping");
		return "Welcome to RunnerZ!";
	}
	
	@GetMapping("")
	List<Run> findAll() {
		return runRepository.findAll();
	}
//	
//	@GetMapping("/{id}")
//	Run findById(@PathVariable Integer id) {
//		Optional<Run> run =  runRepository.findById(id);
//		if(run.isEmpty()) {
//			throw new RunNotFoundException();
//		}
//		
//		return run.get();
//	}
//	
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/createrun")
//	String createRun(@Valid @RequestBody Run run) {
//		runRepository.createRun(run);
//		return "Record created successfully";
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@PutMapping("/updaterun/{id}")
//	String updateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
//		runRepository.updateRun(run, id);
//		return "Record updated successfully";
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@DeleteMapping("/deleterun/{id}") 
//	String deleteRun(@PathVariable Integer id) {
//		runRepository.deleteRun(id);
//		return "Record deleted successfully";
//	}
}
