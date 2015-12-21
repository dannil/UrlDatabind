package com.github.dannil.urldatabind.controller;

import java.util.ArrayList;
import java.util.List;

import com.github.dannil.urldatabind.model.Animal;
import com.github.dannil.urldatabind.model.bind.Bind;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

public class BindController {

	private static BindController bindController;

	private List<Bind<?>> binds;

	public static BindController getInstance() {
		if (bindController == null) {
			bindController = new BindController();
		}
		return bindController;
	}

	private BindController() {
		this.binds = new ArrayList<Bind<?>>();

		Animal a1 = new Animal("Bob", 12);
		Bind<Animal> b1 = new JsonBind<Animal>("json/animals/bob", a1);
		addBind(b1);

		Bind<Animal> b2 = new XmlBind<Animal>("xml/animals/bob", a1);
		addBind(b2);

		Animal a2 = new Animal("Annie", 8);
		Bind<Animal> b3 = new JsonBind<Animal>("json/animals/annie", a2);
		addBind(b3);

		Bind<Animal> b4 = new XmlBind<Animal>("xml/animals/annie", a2);
		addBind(b4);
	}

	public void addBind(Bind<?> bind) {
		for (Bind<?> b : this.binds) {
			if (b.getPath().equals(bind.getPath())) {
				throw new IllegalArgumentException(String.format("A bind with path %s already exists", bind.getPath()));
			}
		}
		this.binds.add(bind);
	}

	public void addBinds(List<Bind<?>> binds) {
		for (Bind<?> bind : binds) {
			this.addBind(bind);
		}
	}

	public List<Bind<?>> getBinds() {
		return this.binds;
	}

}
