package com.github.dannil.urldatabind;

import static spark.Spark.port;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.bind.Bind;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;

public class Initializer {

	public static void main(String[] args) {
		port(7667);

		Initializer initializer = new Initializer();
		initializer.loadModules();

		Bind<String> b1 = new JsonBind<String>("/test", "this is a test");
		Bind<String> b2 = new JsonBind<String>("/test1", "this is a test1");
	}

	public void loadModules() {
		// Run this method to create all necessary resources on startup
		// instead of creating them when users are accessing the system.

		// Create the format builder instance
		// FormatBuilder formatBuilder = FormatBuilder.getInstance();
		FormatBuilder.getInstance();

		// Create the router instance and load the routes
		Router router = Router.getInstance();
		router.loadRoutes();
	}

}
