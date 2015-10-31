package com.github.dannil.urldatabind.builder;

import java.util.HashMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;

public class FormatBuilder {

	private static FormatBuilder formatBuilder;

	// private JsonBuilder jsonBuilder;
	// private XmlBuilder xmlBuilder;

	private Map<Type, IBuilder> builders;

	public static FormatBuilder getInstance() {
		if (formatBuilder == null) {
			formatBuilder = new FormatBuilder();
		}
		return formatBuilder;
	}

	private FormatBuilder() {
		// this.jsonBuilder = new JsonBuilder();
		// this.xmlBuilder = new XmlBuilder();

		this.builders = new HashMap<Type, IBuilder>();
		this.builders.put(Type.JSON, new JsonBuilder());
		this.builders.put(Type.PLAIN, new PlainBuilder());
		this.builders.put(Type.XML, new XmlBuilder());
	}

	public Object getHttpFormat(Type type, Bind<?> bind) {
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
