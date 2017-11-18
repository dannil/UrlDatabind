package com.github.dannil.urldatabind.model.bind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.github.dannil.urldatabind.model.bind.JsonBind;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;
import com.github.dannil.urldatabind.test.model.IBindTest;
import com.github.dannil.urldatabind.test.model.IEqualsTest;

@RunWith(JUnit4.class)
public class JsonBindTest implements IBindTest, IEqualsTest {

	@Test
	@Override
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertNotNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullPathArgument() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind(null, RequestMethod.GET, action);

		assertNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullRequestMethodArgument() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", null, action);

		assertNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullActionArgument() {
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, null);

		assertNull(bind);
	}

	@Test
	@Override
	public void getPath() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertEquals("test", bind.getPath());
	}

	@Test
	@Override
	public void setPath() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		bind.setPath("setTest");

		assertEquals("setTest", bind.getPath());
	}

	@Test
	@Override
	public void getRequestMethod() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertEquals(RequestMethod.GET, bind.getRequestMethod());
	}

	@Test
	@Override
	public void setRequestMethod() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		bind.setRequestMethod(RequestMethod.POST);

		assertEquals(RequestMethod.POST, bind.getRequestMethod());
	}

	@Test
	@Override
	public void getHttpContent() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertEquals("\"en_US\"", bind.getHttpContent());
	}

	// @Test
	// @Override
	// public void setContent() {
	// Locale locale = new Locale("en", "US");
	// AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET,
	// locale);
	//
	// Locale newLocale = new Locale("sv", "SE");
	// bind.setContent(newLocale);
	//
	// assertEquals("SE", bind.getContent().getCountry());
	// }

	// @Test
	// @Override
	// public void getHttpContent() {
	// Locale locale = new Locale("en", "US");
	// AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET,
	// locale);
	//
	// assertEquals("\"en_US\"", bind.getContent());
	// }

	@Test
	@Override
	public void getType() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertEquals(Type.JSON, bind.getType());
	}

	@Test
	@Override
	public void getHttpType() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		assertEquals("application/json", bind.getHttpType());
	}

	@Test
	@Override
	public void toJson() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		AbstractBind newBind = bind.toJson();

		assertEquals(bind, newBind);
	}

	@Test
	@Override
	public void toPlain() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		AbstractBind newBind = bind.toPlain();

		assertNotEquals(bind.getHttpContent(), newBind.getHttpContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.PLAIN, newBind.getType());
	}

	@Test
	@Override
	public void toXml() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind bind = new JsonBind("test", RequestMethod.GET, action);

		AbstractBind newBind = bind.toXml();

		assertNotEquals(bind.getHttpContent(), newBind.getHttpContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.XML, newBind.getType());
	}

	@Test
	public void hashCodeEquals() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new JsonBind("test", RequestMethod.GET, action);

		assertEquals(b1.hashCode(), b2.hashCode());
	}

	@Test
	@Override
	public void equals() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new JsonBind("test", RequestMethod.GET, action);

		assertEquals(b1, b2);
	}

	@Test
	@Override
	public void equalsItself() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);

		assertEquals(b1, b1);
	}

	@Test
	@Override
	public void notEqualsNull() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);
		AbstractBind b2 = null;

		assertNotEquals(b1, b2);
	}

	@Test
	@Override
	public void notEqualsIncompatibleObject() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);

		assertNotEquals(b1, locale);
	}

	@Test
	public void notEqualsPath() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new JsonBind("test2", RequestMethod.GET, action);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsRequestMethod() {
		Locale locale = new Locale("en", "US");
		Action action = new ObjectResult(locale);
		AbstractBind b1 = new JsonBind("test", RequestMethod.GET, action);
		AbstractBind b2 = new JsonBind("test1", RequestMethod.POST, action);

		assertNotEquals(b1, b2);
	}

	// @Test
	// public void notEqualsContent() {
	// Locale locale1 = new Locale("en", "US");
	// JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET,
	// locale1);
	//
	// Locale locale2 = new Locale("sv", "SE");
	// JsonBind<Locale> b2 = new JsonBind<Locale>("test", RequestMethod.GET,
	// locale2);
	//
	// assertNotEquals(b1, b2);
	// }

}
