package com.github.dannil.urldatabind.model.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;

@RunWith(JUnit4.class)
public class JsonBindUnitTest {

	@Test
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		assertNotNull(jsonBind);
	}

	@Test
	public void getPath() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		assertEquals("test", jsonBind.getPath());
	}

	@Test
	public void setPath() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		jsonBind.setPath("setTest");

		assertEquals("setTest", jsonBind.getPath());
	}

	@Test
	public void getContent() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		assertEquals(locale.getCountry(), jsonBind.getContent().getCountry());
	}

	@Test
	public void setContent() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		Locale newLocale = new Locale("sv", "SE");
		jsonBind.setContent(newLocale);

		assertEquals("SE", jsonBind.getContent().getCountry());
	}

	@Test
	public void getHttpContent() {
		// TODO Auto-generated method stub

	}

	@Test
	public void toJson() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		JsonBind<Locale> newJsonBind = jsonBind.toJson();

		assertEquals(jsonBind, newJsonBind);
	}

	@Test
	public void toXml() {
		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		XmlBind<Locale> xmlBind = jsonBind.toXml();

		assertEquals(jsonBind.getContent(), xmlBind.getContent());
		assertEquals(jsonBind.getPath(), xmlBind.getPath());
		assertEquals(Type.XML, xmlBind.getType());
	}
}
