package com.github.dannil.urldatabind.builder;

import java.util.Objects;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.thoughtworks.xstream.XStream;

public class XmlBuilder implements IBuilder {

	// private Serializer serializer;
	// private OutputStream baos;

	private String xmlHeader;

	private XStream xstream;

	public XmlBuilder() {
		// this.serializer = new Persister();
		this.xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

		this.xstream = new XStream();
	}

	@Override
	public Object generate(AbstractBind<?> bind) {
		Class<?> clazz = bind.getContent().getClass();
		this.xstream.alias(clazz.getSimpleName().toLowerCase(), clazz);
		return this.xmlHeader + "\n" + this.xstream.toXML(bind.getContent());

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof XmlBuilder)) {
			return false;
		}

		XmlBuilder other = (XmlBuilder) obj;
		return Objects.equals(this.xmlHeader, other.xmlHeader);
	}

}
