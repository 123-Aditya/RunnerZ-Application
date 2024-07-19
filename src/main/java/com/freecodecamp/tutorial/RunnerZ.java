package com.freecodecamp.tutorial;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.freecodecamp.tutorial.run.Location;
import com.freecodecamp.tutorial.run.Run;

@SpringBootApplication
public class RunnerZ {
	
	private static final Logger LOG = LoggerFactory.getLogger(RunnerZ.class);

	public static void main(String[] args) {
		
//		SpringApplication.run(RunnerZ.class, args);
//		var welcomeMessage = new WelcomeMessage();
//		System.out.println(welcomeMessage.getWelcomeMessage());
		
//		ConfigurableApplicationContext context = SpringApplication.run(RunnerZ.class, args);
//		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
//		System.out.println(welcomeMessage);
		
		SpringApplication.run(RunnerZ.class, args);
		LOG.info("Application started successfully!");
	}
	
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), 
					LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			LOG.info("Run: " + run);
		};
	}

}
