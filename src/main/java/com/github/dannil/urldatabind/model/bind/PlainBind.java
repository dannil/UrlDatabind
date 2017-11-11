package com.github.dannil.urldatabind.model.bind;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * Model for a plain bind.
 * 
 * @author Daniel Nilsson
 */
public class PlainBind extends AbstractBind {

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
    public PlainBind(String path, RequestMethod requestMethod, Action action) {
        super(path, requestMethod, action);
    }

    @Override
    public Type getType() {
        return Type.PLAIN;
    }

    @Override
    public String getHttpType() {
        return "text/plain";
    }

}
