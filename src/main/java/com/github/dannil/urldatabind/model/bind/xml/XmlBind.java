package com.github.dannil.urldatabind.model.bind.xml;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class XmlBind<E> extends AbstractBind<E> {

	public XmlBind(String path, RequestMethod requestMethod, E content) {
		super(path, requestMethod, content);
		// TODO Auto-generated constructor stub
	}

	// @Override
	// public XmlBind<E> toXml() {
	// throw new IllegalArgumentException("Bind is already of type XML");
	// }

	@Override
	public Type getType() {
		return Type.XML;
	}

	@Override
	public String getHttpType() {
		return "application/xml";
	}

}
