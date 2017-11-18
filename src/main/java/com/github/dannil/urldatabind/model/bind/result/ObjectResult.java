package com.github.dannil.urldatabind.model.bind.result;

public class ObjectResult implements Action {

    private Object object;

    public ObjectResult(Object object) {
        this.object = object;
    }

    @Override
    public Object trigger() {
        return this.object;
    }

}
