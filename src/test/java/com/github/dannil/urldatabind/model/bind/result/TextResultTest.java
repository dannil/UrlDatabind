package com.github.dannil.urldatabind.model.bind.result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TextResultTest {

	@Test
	public void createWithConstructor() {
		String text = "foo";
		TextResult result = new TextResult(text);
		
		assertNotNull(result);
	}
	
	@Test
	public void trigger() {
		String text = "foo";
		TextResult result = new TextResult(text);
		
		assertEquals(text, result.trigger());
	}
	
}
