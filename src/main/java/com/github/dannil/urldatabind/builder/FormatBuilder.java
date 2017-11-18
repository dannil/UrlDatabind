package com.github.dannil.urldatabind.builder;

import java.util.EnumMap;
import java.util.Map;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;

/**
 * Builder class for converting a bind's content to HTTP format.
 *
 * @author Daniel Nilsson
 */
public final class FormatBuilder {

    private Map<Type, IBuilder<?>> builders;

    /**
     * Default constructor. Initializes the various builders that can be used.
     */
    private FormatBuilder() {
        this.builders = new EnumMap<>(Type.class);
        this.builders.put(Type.JSON, new JsonBuilder());
        this.builders.put(Type.PLAIN, new PlainBuilder());
        this.builders.put(Type.XML, new XmlBuilder());
    }

    /**
     * Returns the singleton instance.
     * 
     * @return the instance
     */
    public static FormatBuilder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Returns the HTTP format of the action based on the type.
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
     * Private class which contains the FormatBuilder singleton. Implements the
     * initialization-on-demand holder idiom for efficiency purposes.
     */
    private static class SingletonHolder {

        private static final FormatBuilder INSTANCE = new FormatBuilder();

        /**
         * Private constructor.
         */
        private SingletonHolder() {
            // To avoid initialization outside this class
        }

    }

}
