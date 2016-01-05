package com.github.dannil.urldatabind.model.bind.plain;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;

public class PlainBind<E> extends Bind<E> {

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