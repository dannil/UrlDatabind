package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.AbstractBind;

/**
 * Interface for builders.
 * 
 * @author Daniel Nilsson
 *
 * @param <T>
 *            the return type of the content for the implementing builder
 */
public interface IBuilder<T> {

    /**
     * Generate an output of the bind based on the implementing builder.
     * 
     * @param bind
     *            the bind
     * @return a representation of the bind based on the implementing builder
     */
    T generate(AbstractBind bind);

}
