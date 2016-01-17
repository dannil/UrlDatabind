package com.github.dannil.urldatabind;

import static spark.Spark.get;
import static spark.Spark.post;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class Router {

	private static Router routerInstance;

	private static Object lock = new Object();

	public static Router getInstance() {
		synchronized (lock) {
			if (routerInstance == null) {
				routerInstance = new Router();
			}
			return routerInstance;
		}
	}

	private Router() {

	}

	public void createRoute(AbstractBind<?> bind) throws IllegalArgumentException {
		String path = bind.getPath();
		String httpType = bind.getHttpType();
		RequestMethod requestMethod = bind.getRequestMethod();
		Object httpContent = bind.getHttpContent();

		switch (requestMethod) {
			case GET:
				get(path, httpType, (request, response) -> {
					response.type(httpType);
					return httpContent;
				});
				break;

			case POST:
				post(path, httpType, (request, response) -> {
					response.type(httpType);
					return httpContent;
				});
				break;

			default:
				throw new IllegalArgumentException(requestMethod + " is not a valid request method");

		}
	}

	// private Object createRoute(Request req, Response res, Bind<?> b) {
	// res.type(b.getHttpType());
	// return b.getHttpContent();
	// }

}
