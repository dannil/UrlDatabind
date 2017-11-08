package com.github.dannil.urldatabind.model.bind;

import java.util.Objects;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Result;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.plain.PlainBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

/**
 * Abstract bind which implements common functions for binds.
 *
 * @author Daniel Nilsson
 */
public abstract class AbstractBind {

    protected String path;
    protected RequestMethod requestMethod;
    protected Result result;

    /**
     * Overloaded constructor.
     * 
     * @param path
     *            the path
     * @param requestMethod
     *            the HTTP request method
     * @param content
     *            the content
     */
    protected AbstractBind(String path, RequestMethod requestMethod, Result result) {
        if (path == null) {
            throw new IllegalArgumentException("Path can't be null");
        }
        if (requestMethod == null) {
            throw new IllegalArgumentException("RequestMethod can't be null");
        }
        if (result == null) {
            throw new IllegalArgumentException("Content can't be null");
        }

        this.path = path;
        this.requestMethod = requestMethod;
        this.result = result;
    }

    /**
     * Getter for path.
     * 
     * @return the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Setter for path.
     * 
     * @param path
     *            the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Getter for request method.
     * 
     * @return the request method
     */
    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    /**
     * Setter for request method.
     * 
     * @param requestMethod
     *            the request method
     */
    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    // /**
    // * Getter for content.
    // *
    // * @return the content
    // */
    // public E getContent() {
    // return this.content;
    // }
    //
    // /**
    // * Setter for content.
    // *
    // * @param content
    // * the content
    // */
    // public void setContent(E content) {
    // this.content = content;
    // }

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
     * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.json.JsonBind
     *         JsonBind}
     */
    public JsonBind toJson() {
        return new JsonBind<>(this.path, this.requestMethod, this.result);
    }

    /**
     * Convert the bind to a plain format.
     * 
     * @return the bind as a
     *         {@link com.github.dannil.urldatabind.model.bind.plain.PlainBind PlainBind}
     */
    public PlainBind toPlain() {
        return new PlainBind<>(this.path, this.requestMethod, this.result);
    }

    /**
     * Converts the bind to XML format.
     * 
     * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.xml.XmlBind
     *         XmlBind}
     */
    public XmlBind toXml() {
        return new XmlBind<>(this.path, this.requestMethod, this.result);
    }

    public Object transformResult() {
        return result.generate();
    }

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
        AbstractBind other = (AbstractBind) obj;
        return Objects.equals(this.path, other.path) && Objects.equals(this.requestMethod, other.requestMethod);
    }

}
