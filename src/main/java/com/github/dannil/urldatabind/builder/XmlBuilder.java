package com.github.dannil.urldatabind.builder;

import java.util.Objects;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.thoughtworks.xstream.XStream;

/**
 * Builder for XML output.
 * 
 * @author Daniel Nilsson
 */
public class XmlBuilder implements IBuilder<String> {

    private String xmlHeader;

    private XStream xstream;

    /**
     * Default constructor.
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
