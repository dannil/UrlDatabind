package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;

public class PlainBuilder implements IBuilder {

	@Override
	public Object generate(Bind<?> bind) {
		return bind.toString();
	}

	@Override
	public int hashCode() {
		return Type.PLAIN.hashCode();
	}

}
