package com.freecodecamp.tutorial;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

	public String getWelcomeMessage() {
		return "Welcome to SpringBoot Application!";
	}
}
