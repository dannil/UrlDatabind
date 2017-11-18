package com.github.dannil.urldatabind.model.bind;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * Model for a XML bind.
 * 
 * @author Daniel Nilsson
 */
public class XmlBind extends AbstractBind {

    /**
     * Overloaded constructor.
     * 
     * @param path
     *            the path
     * @param requestMethod
     *            the HTTP request method
     * @param action
     *            the action
     */
    public XmlBind(String path, RequestMethod requestMethod, Action action) {
        super(path, requestMethod, action);
    }

    @Override
    public Type getType() {
        return Type.XML;
    }

    @Override
    public String getHttpType() {
        return "application/xml";
    }

}
