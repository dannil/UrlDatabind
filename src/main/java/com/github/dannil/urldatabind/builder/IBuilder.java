package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.result.Action;

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
     * Generate an output of the action based on the implementing builder.
     * 
     * @param action
     *            the action
     * @return a representation of the action based on the implementing builder
     */
    T generate(Action action);

}
