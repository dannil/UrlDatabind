package com.github.dannil.urldatabind.model.bind.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;
import com.github.dannil.urldatabind.test.model.IBindUnitTest;

@RunWith(JUnit4.class)
public class JsonBindUnitTest implements IBindUnitTest {

	@Test
	@Override
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotNull(jsonBind);
	}

	@Test
	@Override
	public void getPath() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("test", jsonBind.getPath());
	}

	@Test
	@Override
	public void setPath() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		jsonBind.setPath("setTest");

		assertEquals("setTest", jsonBind.getPath());
	}

	@Test
	@Override
	public void getRequestMethod() {
		// TODO Auto-generated method stub

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(RequestMethod.GET, jsonBind.getRequestMethod());
	}

	@Test
	@Override
	public void setRequestMethod() {
		// TODO Auto-generated method stub

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		jsonBind.setRequestMethod(RequestMethod.POST);

		assertEquals(RequestMethod.POST, jsonBind.getRequestMethod());
	}

	@Test
	@Override
	public void getContent() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(locale.getCountry(), jsonBind.getContent().getCountry());
	}

	@Test
	@Override
	public void setContent() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		Locale newLocale = new Locale("sv", "SE");
		jsonBind.setContent(newLocale);

		assertEquals("SE", jsonBind.getContent().getCountry());
	}

	@Test
	@Override
	public void getHttpContent() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("\"en_US\"", jsonBind.getHttpContent());
	}

	@Test
	@Override
	public void getType() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(Type.JSON, jsonBind.getType());
	}

	@Test
	@Override
	public void getHttpType() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals("application/json", jsonBind.getHttpType());
	}

	@Test
	@Override
	public void toJson() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		JsonBind<Locale> newJsonBind = jsonBind.toJson();

		assertEquals(jsonBind, newJsonBind);
	}

	@Test
	@Override
	public void toXml() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		XmlBind<Locale> xmlBind = jsonBind.toXml();

		assertEquals(jsonBind.getContent(), xmlBind.getContent());
		assertEquals(jsonBind.getPath(), xmlBind.getPath());
		assertEquals(Type.XML, xmlBind.getType());
	}

	@Test
	public void equals() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);
		JsonBind<Locale> b2 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b2);
	}

	@Test
	public void equalsItself() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertEquals(b1, b1);
	}

	@Test
	public void equalsNull() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);
		JsonBind<Locale> b2 = null;

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsIncompatible() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotEquals(b1, locale);
	}

	@Test
	public void notEqualsPath() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test1", RequestMethod.GET, locale);
		JsonBind<Locale> b2 = new JsonBind<Locale>("test2", RequestMethod.GET, locale);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsRequestMethod() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test1", RequestMethod.GET, locale);
		JsonBind<Locale> b2 = new JsonBind<Locale>("test2", RequestMethod.POST, locale);

		assertNotEquals(b1, b2);
	}

	@Test
	public void notEqualsContent() {
		Locale locale1 = new Locale("en", "US");
		JsonBind<Locale> b1 = new JsonBind<Locale>("test", RequestMethod.GET, locale1);

		Locale locale2 = new Locale("sv", "SE");
		JsonBind<Locale> b2 = new JsonBind<Locale>("test", RequestMethod.GET, locale2);

		assertNotEquals(b1, b2);
	}

}
