package com.github.dannil.urldatabind.model.bind;

import java.util.Objects;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.plain.PlainBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

public abstract class AbstractBind<E> {

	protected String path;
	protected RequestMethod requestMethod;
	protected E content;

	public abstract Type getType();

	public abstract String getHttpType();

	protected AbstractBind(String path, RequestMethod requestMethod, E content) {
		this.path = path;
		this.requestMethod = requestMethod;
		this.content = content;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public RequestMethod getRequestMethod() {
		return this.requestMethod;
	}

	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
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

	public AbstractBind<E> toJson() {
		AbstractBind<E> bind = new JsonBind<E>(this.path, this.requestMethod, this.content);
		return bind;
	}

	public AbstractBind<E> toPlain() {
		AbstractBind<E> bind = new PlainBind<E>(this.path, this.requestMethod, this.content);
		return bind;
	}

	public AbstractBind<E> toXml() {
		AbstractBind<E> bind = new XmlBind<E>(this.path, this.requestMethod, this.content);
		return bind;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.path, this.requestMethod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractBind)) {
			return false;
		}

		AbstractBind<?> other = (AbstractBind<?>) obj;
		return Objects.equals(this.path, other.path) && Objects.equals(this.requestMethod, other.requestMethod);
	}

}
