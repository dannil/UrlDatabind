package com.github.dannil.urldatabind.deprecated;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.github.dannil.urldatabind.model.bind.result.Action;

public class SQLBind extends AbstractBind {

    public SQLBind(String path, RequestMethod requestMethod, Action action) {
        super(path, requestMethod, action);
    }

    @Override
    public Type getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getHttpType() {
        // TODO Auto-generated method stub
        return null;
    }

}
