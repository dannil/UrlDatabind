package com.github.dannil.urldatabind.builder;

import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;

public class FormatBuilder {

	private static FormatBuilder formatBuilderInstance;

	// private JsonBuilder jsonBuilder;
	// private XmlBuilder xmlBuilder;

	private Map<Type, IBuilder> builders;

	private static Object lock = new Object();

	public static FormatBuilder getInstance() {
		synchronized (lock) {
			if (formatBuilderInstance == null) {
				formatBuilderInstance = new FormatBuilder();
			}
			return formatBuilderInstance;
		}
	}

	private FormatBuilder() {
		// this.jsonBuilder = new JsonBuilder();
		// this.xmlBuilder = new XmlBuilder();

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
		// switch (type) {
		// case JSON:
		// //return this.jsonBuilder.generate(bind);
		//
		//
		// case XML:
		// //return this.xmlBuilder.generate(bind);
		//
		// case PLAIN:
		// return bind.getContent();
		//
		// default:
		// throw new IllegalArgumentException("No format of type " + type +
		// " exists");
	}

}
