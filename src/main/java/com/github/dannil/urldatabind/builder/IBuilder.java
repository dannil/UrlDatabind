package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.AbstractBind;

public interface IBuilder {

	Object generate(AbstractBind<?> bind);

	int hashCode();

}
