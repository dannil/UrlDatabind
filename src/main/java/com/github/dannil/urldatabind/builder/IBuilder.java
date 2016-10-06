package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.AbstractBind;

public interface IBuilder {

	/**
	 * Generate an output of the bind based on the implementing builder.
	 * 
	 * @param bind
	 *            the bind
	 * @return a representation of the bind based on the implementing builder
	 */
	Object generate(AbstractBind<?> bind);

}
