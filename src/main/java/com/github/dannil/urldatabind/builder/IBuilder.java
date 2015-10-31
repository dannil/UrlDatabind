package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.Bind;

public interface IBuilder {

	Object generate(Bind<?> bind);

	int hashCode();

}
