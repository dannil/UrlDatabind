package com.github.dannil.urldatabind.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.github.dannil.urldatabind.Router;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.Bind;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;

public class BindController {

	// private List<Bind<?>> binds;
	private Set<Bind<?>> binds;

	private Router router;

	public BindController() {
		// this.binds = new ArrayList<Bind<?>>();
		this.binds = new HashSet<Bind<?>>();

		this.router = Router.getInstance();

		Locale l1 = new Locale("en", "US");
		Bind<Locale> b1 = new JsonBind<Locale>("json/locale/en", RequestMethod.GET, l1);
		addBind(b1);
	}

	public void addBind(Bind<?> bind) {
		if (this.binds.contains(bind)) {
			throw new IllegalArgumentException(String.format("A bind with path %s already exists", bind.getPath()));
		}
		this.binds.add(bind);
		// for (Bind<?> b : this.binds) {
		// if (b.getPath().equals(bind.getPath())) {
		// throw new
		// IllegalArgumentException(String.format("A bind with path %s already exists",
		// bind.getPath()));
		// }
		// }
		// this.binds.add(bind);
	}

	public void addBinds(Collection<Bind<?>> binds) {
		for (Bind<?> bind : binds) {
			this.addBind(bind);
		}
	}

	public Set<Bind<?>> getBinds() {
		return this.binds;
	}

	// public List<Bind<?>> getBinds() {
	// return this.binds;
	// }

}
