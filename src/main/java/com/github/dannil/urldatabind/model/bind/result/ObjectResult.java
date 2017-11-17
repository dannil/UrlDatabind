package com.github.dannil.urldatabind.model.bind.result;

public class ObjectResult<E> implements Action<E> {

    private E object;

    public ObjectResult(E object) {
        this.object = object;
    }

    @Override
    public E trigger() {
        return this.object;
    }

}
