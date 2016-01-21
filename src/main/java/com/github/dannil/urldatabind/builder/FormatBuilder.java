package com.github.dannil.urldatabind.builder;

import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class FormatBuilder {

	private static FormatBuilder instance;

	private static Object lock = new Object();

	private Map<Type, IBuilder> builders;

	public static FormatBuilder getInstance() {
		synchronized (lock) {
			if (instance == null) {
				instance = new FormatBuilder();
			}
			return instance;
		}
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
