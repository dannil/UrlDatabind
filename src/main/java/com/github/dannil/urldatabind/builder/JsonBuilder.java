package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonBuilder implements IBuilder {

	private Gson gson;

	public JsonBuilder() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	public Object generate(AbstractBind<?> bind) {
		return this.gson.toJson(bind.getContent());
	}

	@Override
	public int hashCode() {
		return Type.JSON.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof JsonBuilder)) {
			return false;
		}

		return true;
	}

}
