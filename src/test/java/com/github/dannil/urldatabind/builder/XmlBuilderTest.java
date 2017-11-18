package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;
import com.github.dannil.urldatabind.test.model.IEqualsTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class XmlBuilderTest implements IEqualsTest {

    @Test
    public void generate() {
        IBuilder<String> xmlBuilder = new XmlBuilder();

        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        // JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET,
        // locale);

        assertNotNull(xmlBuilder.generate(action));
    }

    @Test
    public void testHashCode() {
        IBuilder<String> xmlBuilder = new XmlBuilder();

        assertEquals(Type.XML.hashCode(), xmlBuilder.hashCode());
    }

    @Test
    @Override
    public void equals() {
        IBuilder<String> b1 = new XmlBuilder();
        IBuilder<String> b2 = new XmlBuilder();

        assertEquals(b1, b2);
    }

    @Test
    @Override
    public void equalsItself() {
        IBuilder<String> b1 = new XmlBuilder();

        assertEquals(b1, b1);
    }

    @Test
    @Override
    public void notEqualsNull() {
        IBuilder<String> b1 = new XmlBuilder();

        assertNotEquals(b1, null);
    }

    @Test
    @Override
    public void notEqualsIncompatibleObject() {
        IBuilder<String> b1 = new XmlBuilder();

        assertNotEquals(b1, new Object());
    }
}
