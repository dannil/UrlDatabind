package com.github.dannil.urldatabind.model.bind;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;

/**
 * Model for a plain bind.
 * 
 * @author Daniel Nilsson
 *
 * @param <E>
 *            the type of the content to be held in this bind
 */
public class PlainBind<E> extends AbstractBind<E> {

	/**
	 * Overloaded constructor.
	 * 
	 * @param path
	 *            the path
	 * @param requestMethod
	 *            the HTTP request method
	 * @param content
	 *            the content
	 */
	public PlainBind(String path, RequestMethod requestMethod, E content) {
		super(path, requestMethod, content);
	}

	@Override
	public Type getType() {
		return Type.PLAIN;
	}

	@Override
	public String getHttpType() {
		return "text/plain";
	}

}
