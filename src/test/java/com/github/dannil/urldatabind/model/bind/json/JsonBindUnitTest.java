package com.github.dannil.urldatabind.model.bind.json;

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
import com.github.dannil.urldatabind.test.model.IBindUnitTest;
import com.github.dannil.urldatabind.test.model.IEqualsUnitTest;

@RunWith(JUnit4.class)
public class JsonBindUnitTest implements IBindUnitTest, IEqualsUnitTest {

	@Test
	@Override
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullPathArgument() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>(null, RequestMethod.GET, locale);
		
		assertNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullRequestMethodArgument() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", null, locale);
		
		assertNull(bind);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullContentArgument() {
		// Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, null);
		
		assertNull(bind);
	}

	@Test
	@Override
	public void getPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("test", bind.getPath());
	}

	@Test
	@Override
	public void setPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		bind.setPath("setTest");

		assertEquals("setTest", bind.getPath());
	}

	@Test
	@Override
	public void getRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(RequestMethod.GET, bind.getRequestMethod());
	}

	@Test
	@Override
	public void setRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		bind.setRequestMethod(RequestMethod.POST);

		assertEquals(RequestMethod.POST, bind.getRequestMethod());
	}

	@Test
	@Override
	public void getContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(locale.getCountry(), bind.getContent().getCountry());
	}

	@Test
	@Override
	public void setContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		Locale newLocale = new Locale("sv", "SE");
		bind.setContent(newLocale);

		assertEquals("SE", bind.getContent().getCountry());
	}

	@Test
	@Override
	public void getHttpContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("\"en_US\"", bind.getContent());
	}

	@Test
	@Override
	public void getType() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(Type.JSON, bind.getType());
	}

	@Test
	@Override
	public void getHttpType() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("application/json", bind.getHttpType());
	}

	@Test
	@Override
	public void toJson() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toJson();

		assertEquals(bind, newBind);
	}

	@Test
	@Override
	public void toPlain() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toPlain();

		assertEquals(bind.getContent(), newBind.getContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.PLAIN, newBind.getType());
	}

	@Test
	@Override
	public void toXml() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toXml();

		assertEquals(bind.getContent(), newBind.getContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.XML, newBind.getType());
	}

	@Test
	public void hashCodeEquals() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1.hashCode(), b2.hashCode());
	}

	@Test
	@Override
	public void equals() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b2);
	}

	@Test
	@Override
	public void equalsItself() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b1);
	}

	@Test
	@Override
	public void notEqualsNull() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = null;

		assertNotEquals(b1, b2);
	}

	@Test
	@Override
	public void notEqualsIncompatibleObject() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotEquals(b1, locale);
	}

	@Test
	public void notEqualsPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test1", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new JsonBind<Locale>("test2", RequestMethod.GET, locale);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new JsonBind<Locale>("test1", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new JsonBind<Locale>("test1", RequestMethod.POST, locale);

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
