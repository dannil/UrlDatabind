package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertNotNull;

import com.github.dannil.urldatabind.model.bind.result.Action;
import com.github.dannil.urldatabind.model.bind.result.StringResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IBuilderTest {

    private class DummyBuilder implements IBuilder<String> {

        @Override
        public String generate(Action action) {
            return action.toString();
        }

    }

    @Test
    public void generate() {
        DummyBuilder dummy = new DummyBuilder();
        Action action = new StringResult("hello");

        assertNotNull(dummy.generate(action));
    }

}
