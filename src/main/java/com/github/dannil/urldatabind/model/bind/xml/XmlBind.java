package com.github.dannil.urldatabind.model.bind.xml;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

/**
 * Model for a XML bind.
 * 
 * @author Daniel Nilsson
 * 
 * @param <E>
 *            the type of the content to be held in this bind
 */
public class XmlBind<E> extends AbstractBind<E> {

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
	public XmlBind(String path, RequestMethod requestMethod, E content) {
		super(path, requestMethod, content);
	}

	@Override
	public Type getType() {
		return Type.XML;
	}

	@Override
	public String getHttpType() {
		return "application/xml";
	}

}
