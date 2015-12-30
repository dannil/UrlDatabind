package com.github.dannil.urldatabind;

import static spark.Spark.port;

import com.github.dannil.urldatabind.builder.FormatBuilder;

public class Initializer {

	public static void main(String[] args) {
		Initializer initializer = new Initializer();
		initializer.loadWebServer();
		initializer.loadModules();
	}

	public void loadWebServer() {
		port(7667);
	}

	public void loadModules() {
		// Run this method to create all necessary resources on startup
		// instead of creating them when users are accessing the system.

		// Create the format builder instance
		// FormatBuilder formatBuilder = FormatBuilder.getInstance();
		FormatBuilder.getInstance();

		// Create the router instance
		// Router router = Router.getInstance();
	}

}
