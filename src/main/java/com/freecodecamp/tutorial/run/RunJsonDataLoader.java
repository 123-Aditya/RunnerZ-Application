package com.freecodecamp.tutorial.run;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RunJsonDataLoader implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RunJsonDataLoader.class);
	private final RunRepository runRepository;
	private final ObjectMapper objectMapper;
	
	public RunJsonDataLoader(RunRepository runRepository) {
		this.runRepository = runRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(runRepository.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
				
			}
			
			
		}
	}

	
}
