package com.github.dannil.urldatabind.controller;

import java.util.HashSet;
import java.util.Set;

import com.github.dannil.urldatabind.Router;
import com.github.dannil.urldatabind.model.bind.Bind;

public class BindController {

	private Set<Bind<?>> binds;

	private Router router;

	public BindController() {
		this.binds = new HashSet<Bind<?>>();

		this.router = Router.getInstance();
	}

	public void addBind(Bind<?> bind) {
		if (this.binds.contains(bind)) {
			throw new IllegalArgumentException(String.format("The bind %s %s already exists", bind.getRequestMethod(), bind.getPath()));
		}
		this.binds.add(bind);
	}

	public void removeBind(Bind<?> bind) {
		this.binds.remove(bind);
	}

	public Set<Bind<?>> getBinds() {
		return this.binds;
	}

	public void loadBinds() {
		for (Bind<?> b : this.binds) {
			this.router.createRoute(b);
		}
	}

}
