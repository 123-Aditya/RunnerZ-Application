package com.freecodecamp.tutorial.run;

public interface IConstants {

	static final String  CREATED_SUCCESSFULLY = "Record created and saved successfully";
	static final String WELCOME_MESSAGE = "Welcome to RunnerZ";
	static final String EXCLAMATION = "!"; 
	static final String  EDITED_SUCCESSFULLY = "Record updated successfully";
	static final String  DELETED_SUCCESSFULLY = "Record removed successfully";
	static final String BASE_URL = "/api/runs";
	static final String WELCOME_URL = "/welcome";
	static final String EMPTY_URL = "";
	static final String TOTAL_MILES_URL = "/{username}/totaldistance";
	static final String SAVE_RUN_URL = "/saverun";
	static final String EDIT_RUN_URL = "/editrun/{id}";
	static final String DELETE_RUN_URL = "/removerun/{id}";
}
