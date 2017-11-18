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

package com.github.dannil.urldatabind.builder;

import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * <p>Interface for builders.</p>
 *
 * @param <T>
 *            the return type of the content for the implementing builder
 *
 * @since 0.1.0
 */
public interface IBuilder<T> {

    /**
     * <p>Generate an output of the action based on the implementing builder.</p>
     *
     * @param action
     *            the action
     * @return a representation of the action based on the implementing builder
     */
    T generate(Action action);

}
