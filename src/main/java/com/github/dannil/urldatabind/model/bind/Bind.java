package com.github.dannil.urldatabind.model.bind;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.content == null) ? 0 : this.content.hashCode());
		result = prime * result + ((this.path == null) ? 0 : this.path.hashCode());
		return result;
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
		Bind other = (Bind) obj;
		if (this.content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!this.content.equals(other.content)) {
			return false;
		}
		if (this.path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!this.path.equals(other.path)) {
			return false;
		}
		return true;
	}

}
