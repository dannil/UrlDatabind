package com.github.dannil.urldatabind.controller;

import java.util.HashSet;
import java.util.Set;

import com.github.dannil.urldatabind.Router;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class BindController {

	private Set<AbstractBind<?>> binds;

	private Router router;

	public BindController() {
		this.binds = new HashSet<AbstractBind<?>>();

		this.router = Router.getInstance();
	}

	public void addBind(AbstractBind<?> bind) {
		if (this.binds.contains(bind)) {
			throw new IllegalArgumentException(String.format("The bind %s %s already exists", bind.getRequestMethod(), bind.getPath()));
		}
		this.binds.add(bind);
	}

	public void removeBind(AbstractBind<?> bind) {
		this.binds.remove(bind);
	}

	public Set<AbstractBind<?>> getBinds() {
		return this.binds;
	}

	public void loadBinds() {
		for (AbstractBind<?> b : this.binds) {
			this.router.createRoute(b);
		}
	}

}
