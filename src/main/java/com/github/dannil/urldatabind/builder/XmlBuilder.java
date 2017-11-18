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

import java.util.Objects;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.thoughtworks.xstream.XStream;

/**
 * <p>Builder for XML output.</p>
 *
 * @since 0.1.0
 */
public class XmlBuilder implements IBuilder<String> {

    private String xmlHeader;

    private XStream xstream;

    /**
     * <p>Default constructor.</p>
     */
    public XmlBuilder() {
        this.xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

        this.xstream = new XStream();
    }

    @Override
    public String generate(Action action) {
        Object trigger = action.trigger();
        Class<?> clazz = trigger.getClass();
        this.xstream.alias(clazz.getSimpleName().toLowerCase(), clazz);
        return this.xmlHeader + "\n" + this.xstream.toXML(trigger);
    }

    @Override
    public int hashCode() {
        return Type.XML.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof XmlBuilder)) {
            return false;
        }

        XmlBuilder other = (XmlBuilder) obj;
        return Objects.equals(this.xmlHeader, other.xmlHeader);
    }

}
