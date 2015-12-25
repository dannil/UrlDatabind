package com.github.dannil.urldatabind.model.bind;

import java.util.Objects;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

public abstract class Bind<E> {

	protected String path;
	protected E content;

	public abstract Type getType();

	public abstract String getHttpType();

	protected Bind(String path, E content) {
		this.path = path;
		this.content = content;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public E getContent() {
		return this.content;
	}

	public void setContent(E content) {
		this.content = content;
	}

	public Object getHttpContent() {
		FormatBuilder formatBuilder = FormatBuilder.getInstance();
		return formatBuilder.getHttpFormat(this.getType(), this);
	}

	public JsonBind<E> toJson() {
		JsonBind<E> bind = new JsonBind<E>(this.path, this.content);
		return bind;
	}

	public XmlBind<E> toXml() {
		XmlBind<E> bind = new XmlBind<E>(this.path, this.content);
		return bind;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.path, this.content);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Bind)) {
			return false;
		}

		Bind<?> other = (Bind<?>) obj;
		return Objects.equals(this.path, other.path) && Objects.equals(this.content, other.content);
	}

}
