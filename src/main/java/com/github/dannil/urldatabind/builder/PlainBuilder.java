package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

/**
 * Builder for plain output (the {@link java.lang.Object#toString() toString()}
 * representation of a binds content).
 * 
 * @author Daniel Nilsson
 */
public class PlainBuilder implements IBuilder<String> {

	@Override
	public String generate(AbstractBind<?> bind) {
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
	}

}
