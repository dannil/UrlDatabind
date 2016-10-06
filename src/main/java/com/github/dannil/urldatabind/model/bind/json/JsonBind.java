package com.github.dannil.urldatabind.model.bind.json;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class JsonBind<E> extends AbstractBind<E> {

	/**
	 * Overloaded constructor.
	 * 
	 * @param path the path
	 * @param requestMethod the HTTP request method
	 * @param content the content
	 */
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
