package com.github.dannil.urldatabind.builder;

import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class FormatBuilder {

	private Map<Type, IBuilder> builders;

	// Initialization-on-demand holder idiom
	private static class SingletonHolder {
		static final FormatBuilder INSTANCE = new FormatBuilder();
	}

	public static FormatBuilder getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private FormatBuilder() {
		this.builders = new EnumMap<Type, IBuilder>(Type.class);
		this.builders.put(Type.JSON, new JsonBuilder());
		this.builders.put(Type.PLAIN, new PlainBuilder());
		this.builders.put(Type.XML, new XmlBuilder());
	}

	public Object getHttpFormat(Type type, AbstractBind<?> bind) {
		if (!this.builders.containsKey(type)) {
			throw new IllegalArgumentException(String.format("No builder for type %s exists", type));
		}
		return this.builders.get(type).generate(bind);
	}

}
