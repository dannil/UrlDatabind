package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Builder for JSON output.
 * 
 * @author Daniel Nilsson
 */
public class JsonBuilder implements IBuilder<String> {

	private Gson gson;

	/**
	 * Default constructor.
	 */
	public JsonBuilder() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	@Override
	public String generate(Action action) {
		return this.gson.toJson(action.trigger());
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
		return obj instanceof JsonBuilder;
	}

}
