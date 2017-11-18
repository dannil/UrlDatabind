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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>Builder for JSON output.</p>
 *
 * @since 0.1.0
 */
public class JsonBuilder implements IBuilder<String> {

    private Gson gson;

    /**
     * <p>Default constructor.</p>
     */
    public JsonBuilder() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public String generate(Action action) {
        return this.gson.toJson(action.trigger());
    }

    @Override
    public int hashCode() {
        return Type.JSON.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj instanceof JsonBuilder;
    }

}
