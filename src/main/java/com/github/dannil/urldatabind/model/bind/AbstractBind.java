/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.urldatabind.model.bind;

import java.util.Objects;

import com.github.dannil.urldatabind.builder.FormatBuilder;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * <p>Abstract bind which implements common functions for binds.</p>
 *
 * @since 0.1.0
 */
public abstract class AbstractBind {

    private String path;

    private RequestMethod requestMethod;

    private Action action;

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param path
     *            the path
     * @param requestMethod
     *            the HTTP request method
     * @param action
     *            the action
     */
    protected AbstractBind(String path, RequestMethod requestMethod, Action action) {
        if (path == null) {
            throw new IllegalArgumentException("Path can't be null");
        }
        if (requestMethod == null) {
            throw new IllegalArgumentException("RequestMethod can't be null");
        }
        if (action == null) {
            throw new IllegalArgumentException("Content can't be null");
        }
        this.path = path;
        this.requestMethod = requestMethod;
        this.action = action;
    }

    /**
     * <p>Getter for path.</p>
     *
     * @return the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * <p>Setter for path.</p>
     *
     * @param path
     *            the path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * <p>Getter for request method.</p>
     *
     * @return the request method
     */
    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    /**
     * <p>Setter for request method.</p>
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
     * <p>Returns the HTTP content of the performed action.</p>
     *
     * @return the HTTP content of the performed action
     */
    public Object getHttpContent() {
        FormatBuilder formatBuilder = FormatBuilder.getInstance();
        return formatBuilder.getHttpFormat(this.getType(), this.action);
    }

    /**
     * <p>Converts the bind to JSON format.</p>
     *
     * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.JsonBind
     *         JsonBind}
     */
    public JsonBind toJson() {
        return new JsonBind(this.path, this.requestMethod, this.action);
    }

    /**
     * <p>Convert the bind to a plain format.</p>
     *
     * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.PlainBind
     *         PlainBind}
     */
    public PlainBind toPlain() {
        return new PlainBind(this.path, this.requestMethod, this.action);
    }

    /**
     * <p>Converts the bind to XML format.</p>
     *
     * @return the bind as a {@link com.github.dannil.urldatabind.model.bind.XmlBind
     *         XmlBind}
     */
    public XmlBind toXml() {
        return new XmlBind(this.path, this.requestMethod, this.action);
    }

    /**
     * <p>Returns the type of the bind.</p>
     *
     * @return the type
     */
    public abstract Type getType();

    /**
     * <p>Returns the HTTP type of the bind, as specified by <a
     * href="https://www.iana.org/assignments/media-types/media-types.xhtml">IANA</a>.</p>
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
