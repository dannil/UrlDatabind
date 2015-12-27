package com.github.dannil.urldatabind;

import static spark.Spark.get;

import java.util.Collection;

import spark.Request;
import spark.Response;

import com.github.dannil.urldatabind.model.bind.Bind;

public class Router {

	private static Router router;

	public static Router getInstance() {
		if (router == null) {
			router = new Router();
		}
		return router;
	}

	private Router() {

	}

	public void createRoute(Collection<Bind<?>> binds) {
		for (Bind<?> b : binds) {
			get(b.getPath(), b.getHttpType(), (request, response) -> createRoute(request, response, b));
		}

		// for (Bind<?> b : this.bindController.getBinds()) {
		// get(b.getPath(), b.getHttpType(), (request, response) ->
		// createRoute(request, response, b));
		// }
		// get("/", (request, response) -> "Hello World!");
	}

	private Object createRoute(Request req, Response res, Bind<?> b) {
		res.type(b.getHttpType());
		return b.getHttpContent();
	}

}
