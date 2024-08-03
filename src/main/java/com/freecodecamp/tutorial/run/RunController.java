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
@RequestMapping(IConstants.BASE_URL)
public class RunController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RunController.class);

	public final RunRepository runRepository;
	
	public RunController(RunRepository runRepository) {
		this.runRepository = runRepository;
	}
	
	@GetMapping(IConstants.WELCOME_URL)
	String name() {
		LOG.info("Returning response for /hello mapping");
		return IConstants.WELCOME_MESSAGE + IConstants.EXCLAMATION;
	}
	
	@GetMapping(IConstants.EMPTY_URL)
	List<Run> findAll() {
		return runRepository.findAll();
	}
	
	@GetMapping("/{id}")
	Run findById(@PathVariable Integer id) {
		Optional<Run> run =  runRepository.findById(id);
		if(run.isEmpty()) {
			throw new RunNotFoundException();
		}
		
		return run.get();
	}
	
	@GetMapping(IConstants.TOTAL_MILES_URL)
	int findTotalMilesRan(@PathVariable String username) {
		List<Run> runs =  runRepository.findForSpecificUser(username);
		if(runs.isEmpty()) {
			throw new RunNotFoundException();
		}
		int totalMiles = 0;
		for(int i=0;i<runs.size();i++) {
			totalMiles += runs.get(i).miles();
		}
		return totalMiles;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(IConstants.SAVE_RUN_URL)
	String createRun(@Valid @RequestBody Run run) {
		runRepository.createRun(run);
		return IConstants.CREATED_SUCCESSFULLY;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping(IConstants.EDIT_RUN_URL)
	String updateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
		runRepository.updateRun(run, id);
		return IConstants.EDITED_SUCCESSFULLY;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(IConstants.DELETE_RUN_URL) 
	String deleteRun(@PathVariable Integer id) {
		runRepository.deleteRun(id);
		return IConstants.DELETED_SUCCESSFULLY;
	}
}
