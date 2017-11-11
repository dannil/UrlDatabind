package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.JsonBind;

@RunWith(JUnit4.class)
public class FormatBuilderUnitTest {

    @Test
    public void getInstance() {
        FormatBuilder formatBuilder = FormatBuilder.getInstance();

        assertNotEquals(null, formatBuilder);
    }

    @Test
    public void getHttpFormat() {
        FormatBuilder formatBuilder = FormatBuilder.getInstance();

        Locale locale = new Locale("en", "US");
        JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

        assertEquals("\"en_US\"", formatBuilder.getHttpFormat(jsonBind.getType(), jsonBind));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getHttpFormatInvalidType() {
        FormatBuilder formatBuilder = FormatBuilder.getInstance();

        Locale locale = new Locale("en", "US");
        JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

        formatBuilder.getHttpFormat(null, jsonBind);
    }

    @Test
    public void callPrivateConstructorSingletonHolder() throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Ridiculous code to instantiate private static class inside a private
        // class
        Class<?> enclosingClass = FormatBuilder.class;
        Constructor<?> enclosingConstructor = enclosingClass.getDeclaredConstructor();
        enclosingConstructor.setAccessible(true);

        // Make sure we instantiate the correct inner class
        String innerClassName = "SingletonHolder";
        Class<?> innerClass = null;
        Class<?>[] innerClasses = FormatBuilder.class.getDeclaredClasses();
        for (int i = 0; i < innerClasses.length; i++) {
            if (innerClasses[i].toString().contains(innerClassName)) {
                // We found the correct class!
                innerClass = innerClasses[i];
            }
        }
        assertTrue(innerClass.toString().contains(innerClassName));

        Constructor<?> innerConstructor = innerClass.getDeclaredConstructors()[0];

        innerConstructor.setAccessible(true);
        innerConstructor.newInstance();
        innerConstructor.setAccessible(false);

        assertFalse(innerConstructor.isAccessible());
    }

}
