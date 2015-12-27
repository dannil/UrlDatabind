package com.github.dannil.urldatabind.model.bind.json;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;

public class JsonBind<E> extends Bind<E> {

	public JsonBind(String path, RequestMethod requestMethod, E content) {
		super(path, requestMethod, content);
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public JsonBind<E> toJson() {
	// throw new IllegalArgumentException("Bind is already of type JSON");
	// }

	@Override
	public Type getType() {
		return Type.JSON;
	}

	@Override
	public String getHttpType() {
		return "application/json";
	}

}
