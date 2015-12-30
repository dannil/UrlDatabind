package com.github.dannil.urldatabind;

import static spark.Spark.get;
import static spark.Spark.post;
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

	public void createRoute(Bind<?> bind) {
		switch (bind.getRequestMethod()) {
			case GET:
				get(bind.getPath(), bind.getHttpType(), (request, response) -> createRoute(request, response, bind));
				break;

			case POST:
				post(bind.getPath(), bind.getHttpType(), (request, response) -> createRoute(request, response, bind));
				break;

			default:
				break;

		}
	}

	private Object createRoute(Request req, Response res, Bind<?> b) {
		res.type(b.getHttpType());
		return b.getHttpContent();
	}

}
