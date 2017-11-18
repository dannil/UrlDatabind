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

package com.github.dannil.urldatabind.model.bind;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * <p>Model for a plain bind.</p>
 *
 * @since 0.1.0
 */
public class PlainBind extends AbstractBind {

    /**
     * <p>Overloaded constructor.</p>
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
