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

import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * <p>Builder class for converting a bind's action content to HTTP format.</p>
 *
 * @since 0.1.0
 */
public final class FormatBuilder {

    private Map<Type, IBuilder<?>> builders;

    /**
     * <p>Default constructor. Initializes the various builders that can be used.</p>
     */
    private FormatBuilder() {
        this.builders = new EnumMap<>(Type.class);
        this.builders.put(Type.JSON, new JsonBuilder());
        this.builders.put(Type.PLAIN, new PlainBuilder());
        this.builders.put(Type.XML, new XmlBuilder());
    }

    /**
     * <p>Returns the singleton instance.</p>
     *
     * @return the instance
     */
    public static FormatBuilder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * <p>Returns the HTTP format of the action based on the type.</p>
     *
     * @param type
     *            the type
     * @param action
     *            the action
     * @return the HTTP format of the action based on the type
     */
    public Object getHttpFormat(Type type, Action action) {
        if (!this.builders.containsKey(type)) {
            throw new IllegalArgumentException(String.format("No builder exists for type %s", type));
        }
        return this.builders.get(type).generate(action);
    }

    /**
     * <p>Private class which contains the FormatBuilder singleton. Implements the
     * initialization-on-demand holder idiom for efficiency purposes.</p>
     */
    private static final class SingletonHolder {

        private static final FormatBuilder INSTANCE = new FormatBuilder();

        /**
         * <p>Private constructor.</p>
         */
        private SingletonHolder() {
            // To avoid initialization outside this class
        }

    }

}
