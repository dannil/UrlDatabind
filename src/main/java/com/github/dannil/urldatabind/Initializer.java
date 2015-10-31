package com.github.dannil.urldatabind;

import static spark.Spark.port;

import com.github.dannil.urldatabind.builder.FormatBuilder;

public class Initializer {

	public static void main(String[] args) {
		port(7667);

		Initializer initializer = new Initializer();
		initializer.loadModules();

		Router router = Router.getInstance();
		router.loadRoutes();
	}

	public void loadModules() {
		// Run this method to create all necessary resources on startup
		// instead of creating them when users are accessing the system.

		// Create the format builder instance
		// FormatBuilder formatBuilder = FormatBuilder.getInstance();
		FormatBuilder.getInstance();
	}

}
