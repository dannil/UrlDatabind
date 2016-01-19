package com.github.dannil.urldatabind.model.bind.plain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;
import com.github.dannil.urldatabind.test.model.IBindUnitTest;

@RunWith(JUnit4.class)
public class PlainBindUnitTest implements IBindUnitTest {

	@Test
	@Override
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertNotNull(bind);
	}

	@Test
	@Override
	public void getPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("test", bind.getPath());
	}

	@Test
	@Override
	public void setPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		bind.setPath("setTest");

		assertEquals("setTest", bind.getPath());
	}

	@Test
	@Override
	public void getRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(RequestMethod.GET, bind.getRequestMethod());
	}

	@Test
	@Override
	public void setRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		bind.setRequestMethod(RequestMethod.POST);

		assertEquals(RequestMethod.POST, bind.getRequestMethod());
	}

	@Test
	@Override
	public void getContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(locale.getCountry(), bind.getContent().getCountry());
	}

	@Test
	@Override
	public void setContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		Locale newLocale = new Locale("sv", "SE");
		bind.setContent(newLocale);

		assertEquals("SE", bind.getContent().getCountry());
	}

	@Test
	@Override
	public void getHttpContent() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(bind.getContent().toString(), bind.getHttpContent());
	}

	@Test
	@Override
	public void getType() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(Type.PLAIN, bind.getType());
	}

	@Test
	@Override
	public void getHttpType() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("text/plain", bind.getHttpType());
	}

	@Test
	@Override
	public void toJson() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toJson();

		assertEquals(bind.getContent(), newBind.getContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.JSON, newBind.getType());
	}

	@Test
	@Override
	public void toPlain() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new XmlBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toPlain();

		assertEquals(bind, newBind);
	}

	@Test
	@Override
	public void toXml() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> bind = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		AbstractBind<Locale> newBind = bind.toXml();

		assertEquals(bind.getContent(), newBind.getContent());
		assertEquals(bind.getPath(), newBind.getPath());
		assertEquals(Type.XML, newBind.getType());
	}

	@Test
	public void equals() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b2);
	}

	@Test
	public void equalsItself() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b1);
	}

	@Test
	public void equalsNull() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = null;

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsIncompatible() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test", RequestMethod.GET, locale);

		assertNotEquals(b1, locale);
	}

	@Test
	public void notEqualsPath() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test1", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new PlainBind<Locale>("test2", RequestMethod.GET, locale);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsRequestMethod() {
		Locale locale = new Locale("en", "US");
		AbstractBind<Locale> b1 = new PlainBind<Locale>("test1", RequestMethod.GET, locale);
		AbstractBind<Locale> b2 = new PlainBind<Locale>("test2", RequestMethod.POST, locale);

		assertNotEquals(b1, b2);
	}

}
