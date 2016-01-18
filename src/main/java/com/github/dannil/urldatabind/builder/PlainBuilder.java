package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class PlainBuilder implements IBuilder {

	public PlainBuilder() {
		super();
	}

	@Override
	public Object generate(AbstractBind<?> bind) {
		return bind.getContent().toString();
	}

	@Override
	public int hashCode() {
		return Type.PLAIN.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		return obj instanceof PlainBuilder;
		// if (!(obj instanceof PlainBuilder)) {
		// return false;
		// }
		//
		// return true;
	}

}
