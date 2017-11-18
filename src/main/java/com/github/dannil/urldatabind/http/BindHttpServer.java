package com.github.dannil.urldatabind.http;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.port;

import java.util.Set;

import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class BindHttpServer {

	private Set<AbstractBind> binds;

	public BindHttpServer(Set<AbstractBind> binds) {
		this.binds = binds;
	}

	public void start(int port) {
		port(port);
		for (final AbstractBind bind : binds) {
			switch (bind.getRequestMethod()) {
			case GET:
				get(bind.getPath(), (request, response) -> {
					response.type(bind.getHttpType());
					return bind.getHttpContent();
				});
			case POST:
				post(bind.getPath(), (request, response) -> {
					response.type(bind.getHttpType());
					return bind.getHttpContent();
				});
			}
		}
	}

	public void stop() {
		spark.Spark.stop();
	}

}
