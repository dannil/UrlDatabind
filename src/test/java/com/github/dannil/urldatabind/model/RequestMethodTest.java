package com.github.dannil.urldatabind.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RequestMethodTest {

    @Test
    public void valueOf() {
        RequestMethod method = RequestMethod.valueOf("GET");

        assertEquals(RequestMethod.GET, method);
    }

    @Test
    public void values() {
        RequestMethod[] methods = RequestMethod.values();

        assertNotNull(methods);
    }

}
