package com.freecodecamp.tutorial.run;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public class RunJsonDataLoader implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RunJsonDataLoader.class);
	private final RunRepository runRepository;
	private final ObjectMapper objectMapper;
	
	public RunJsonDataLoader(RunRepository runRepository, ObjectMapper objectMapper) {
		this.runRepository = runRepository;
		this.objectMapper = objectMapper;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(runRepository.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
				Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
				LOG.info("Reading {} runs from JSON data and saving to H2 DB.", allRuns.runs().size());
				runRepository.saveAll(allRuns.runs());
			}	catch(IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			LOG.info("Not loading runs from JSON data because the collection contains data");
		}
	}

	
}
