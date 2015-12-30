package com.github.dannil.urldatabind;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.threadPool;

import com.github.dannil.urldatabind.builder.FormatBuilder;

public class Initializer {

	public static void main(String[] args) {
		Initializer initializer = new Initializer();
		initializer.loadWebServer();
		initializer.loadModules();
	}

	public void loadWebServer() {
		// Define the maximum and minimum number of threads, as well as the
		// timeout time in milliseconds.
		threadPool(8, 2, 30000);

		// Start the web server on the defined port
		port(6776);

		// Hello World!
		get("/", (request, response) -> "Hello World!");
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
