package com.github.dannil.urldatabind.model.bind.result;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ActionTest {

	private class DummyAction implements Action {

		@Override
		public Object trigger() {
			return Math.PI;
		}
		
	}
	
	@Test
	public void trigger() {
		DummyAction dummy = new DummyAction();
		assertEquals(Math.PI, dummy.trigger());
	}
	
}
