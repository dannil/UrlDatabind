package com.github.dannil.urldatabind.model.bind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;
import com.github.dannil.urldatabind.model.bind.result.TextResult;
import com.github.dannil.urldatabind.test.model.IEqualsTest;

@RunWith(JUnit4.class)
public class AbstractBindTest implements IEqualsTest {

	public class DummyBind extends AbstractBind {

		protected DummyBind(String path, RequestMethod requestMethod, Action action) {
			super(path, requestMethod, action);
		}

		@Override
		public Type getType() {
			return null;
		}

		@Override
		public String getHttpType() {
			return null;
		}
		
	}
	
	@Test
	@Override
	public void equals() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new DummyBind("test", RequestMethod.GET, action);

		assertEquals(b1, b2);
	}

	@Test
	@Override
	public void equalsItself() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);

		assertEquals(b1, b1);
	}

	@Test
	@Override
	public void notEqualsNull() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);
		AbstractBind b2 = null;

		assertNotEquals(b1, b2);
	}

	@Test
	@Override
	public void notEqualsIncompatibleObject() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);

		assertNotEquals(b1, locale);
	}

	@Test
	public void notEqualsPath() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new DummyBind("test1", RequestMethod.GET, action);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsRequestMethod() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new DummyBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new DummyBind("test", RequestMethod.POST, action);

		assertNotEquals(b1, b2);
	}

}
