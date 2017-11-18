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

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * <p>Builder for plain output (the {@link java.lang.Object#toString() toString()}
 * representation of a bind's action content).</p>
 *
 * @since 0.1.0
 */
public class PlainBuilder implements IBuilder<String> {

    /**
     * <p>Default constructor.</p>
     */
    public PlainBuilder() {

    }

    @Override
    public String generate(Action action) {
        return String.valueOf(action.trigger());
    }

    @Override
    public int hashCode() {
        return Type.PLAIN.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj instanceof PlainBuilder;
    }

}
