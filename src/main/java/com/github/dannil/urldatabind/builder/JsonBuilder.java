package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonBuilder implements IBuilder {

	private Gson gson;

	public JsonBuilder() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	public Object generate(Bind<?> bind) {
		return this.gson.toJson(bind.getContent());
	}

	@Override
	public int hashCode() {
		return Type.JSON.hashCode();
	}

}
