package com.github.dannil.urldatabind.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TypeUnitTest {

    @Test
    public void valueOf() {
        Type type = Type.valueOf("JSON");

        assertEquals(Type.JSON, type);
    }

    @Test
    public void values() {
        Type[] types = Type.values();

        assertNotNull(types);
    }

}
