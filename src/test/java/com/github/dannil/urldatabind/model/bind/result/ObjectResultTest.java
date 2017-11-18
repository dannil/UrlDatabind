package com.github.dannil.urldatabind.model.bind.result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ObjectResultTest {

    @Test
    public void createWithConstructor() {
        Object object = new Object();
        ObjectResult result = new ObjectResult(object);

        assertNotNull(result);
    }

    @Test
    public void trigger() {
        Object object = new Object();
        ObjectResult result = new ObjectResult(object);

        assertEquals(object, result.trigger());
    }

}
