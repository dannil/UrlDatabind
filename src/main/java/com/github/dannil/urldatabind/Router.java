package com.github.dannil.urldatabind;

import static spark.Spark.get;
import spark.Request;
import spark.Response;

import com.github.dannil.urldatabind.controller.BindController;
import com.github.dannil.urldatabind.model.bind.Bind;

public class Router {

	private static Router router;

	private BindController bindController;

	public static Router getInstance() {
		if (router == null) {
			router = new Router();
		}
		return router;
	}

	private Router() {
		this.bindController = BindController.getInstance();
	}

	public void loadRoutes() {
		for (Bind<?> b : this.bindController.getBinds()) {
			get(b.getPath(), (request, response) -> createRoute(request, response, b));
		}
		// get("/", (request, response) -> "Hello World!");
	}

	private Object createRoute(Request req, Response res, Bind<?> b) {
		res.type(b.getHttpType());
		return b.getHttpContent();
	}

}
