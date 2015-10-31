package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.Bind;
import com.thoughtworks.xstream.XStream;

public class XmlBuilder implements IBuilder {

	// private Serializer serializer;
	// private OutputStream baos;

	private XStream xstream;

	public XmlBuilder() {
		// this.serializer = new Persister();
		this.xstream = new XStream();
	}

	@Override
	public Object generate(Bind<?> bind) {
		Class<?> clazz = bind.getContent().getClass();
		this.xstream.alias(clazz.getSimpleName().toLowerCase(), clazz);
		return this.xstream.toXML(bind.getContent());

		// this.baos = new ByteArrayOutputStream();
		// try {
		// this.serializer.write(bind.getContent(), this.baos);
		// String format = this.baos.toString();
		// this.baos.close();
		// return format;
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return null;
	}

	@Override
	public int hashCode() {
		return Type.XML.hashCode();
	}

}
