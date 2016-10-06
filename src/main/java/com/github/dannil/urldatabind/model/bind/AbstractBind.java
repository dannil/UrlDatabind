package com.github.dannil.urldatabind.model.bind;

import java.util.Objects;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.plain.PlainBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

/**
 * Abstract bind which implements common functions for binds.
 * 
 * @author Daniel Nilsson
 *
 * @param <E> the datatype of the content
 */
public abstract class AbstractBind<E> {

	protected String path;
	protected RequestMethod requestMethod;
	protected E content;

	/**
	 * Returns the type of the bind.
	 * 
	 * @return the type
	 */
	public abstract Type getType();

	/**
	 * Returns the HTTP type of the bind.
	 * 
	 * @return the HTTP type
	 */
	public abstract String getHttpType();

	protected AbstractBind(String path, RequestMethod requestMethod, E content) {
		if (path == null) {
			throw new IllegalArgumentException("Path can't be null");
		}
		if (requestMethod == null) {
			throw new IllegalArgumentException("RequestMethod can't be null");
		}
		if (content == null) {
			throw new IllegalArgumentException("Content can't be null");
		}

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

	/**
	 * Returns the HTTP format of the content.
	 * 
	 * @return the HTTP format of the content
	 */
	public Object getHttpContent() {
		FormatBuilder formatBuilder = FormatBuilder.getInstance();
		return formatBuilder.getHttpFormat(this.getType(), this);
	}

	/**
	 * Converts the bind to JSON format.
	 * 
	 * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.JsonBind JsonBind}
	 */
	public JsonBind<E> toJson() {
		JsonBind<E> bind = new JsonBind<E>(this.path, this.requestMethod, this.content);
		return bind;
	}

	public PlainBind<E> toPlain() {
		PlainBind<E> bind = new PlainBind<E>(this.path, this.requestMethod, this.content);
		return bind;
	}

	/**
	 * Converts the bind to XML format.
	 * 
	 * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.XmlBind XmlBind}
	 */
	public XmlBind<E> toXml() {
		XmlBind<E> bind = new XmlBind<E>(this.path, this.requestMethod, this.content);
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
