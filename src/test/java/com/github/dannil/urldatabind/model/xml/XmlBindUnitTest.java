package com.github.dannil.urldatabind.model.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.model.bind.xml.XmlBind;
import com.github.dannil.urldatabind.test.model.IBindUnitTest;

@RunWith(JUnit4.class)
public class XmlBindUnitTest implements IBindUnitTest {

	@Test
	@Override
	public void createWithConstructor() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertNotNull(xmlBind);
	}

	@Test
	@Override
	public void getPath() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertEquals("test", xmlBind.getPath());
	}

	@Test
	@Override
	public void setPath() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		xmlBind.setPath("setTest");

		assertEquals("setTest", xmlBind.getPath());
	}

	@Test
	@Override
	public void getContent() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertEquals(locale.getCountry(), xmlBind.getContent().getCountry());
	}

	@Test
	@Override
	public void setContent() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		Locale newLocale = new Locale("sv", "SE");
		xmlBind.setContent(newLocale);

		assertEquals("SE", xmlBind.getContent().getCountry());
	}

	@Test
	@Override
	public void getHttpContent() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<locale>en_US</locale>", xmlBind.getHttpContent());
	}

	@Test
	@Override
	public void getType() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertEquals(Type.XML, xmlBind.getType());
	}

	@Test
	@Override
	public void getHttpType() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		assertEquals("application/xml", xmlBind.getHttpType());
	}

	@Test
	@Override
	public void toJson() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		JsonBind<Locale> jsonBind = xmlBind.toJson();

		assertEquals(xmlBind.getContent(), jsonBind.getContent());
		assertEquals(xmlBind.getPath(), jsonBind.getPath());
		assertEquals(Type.JSON, jsonBind.getType());
	}

	@Test
	@Override
	public void toXml() {
		Locale locale = new Locale("en", "US");
		XmlBind<Locale> xmlBind = new XmlBind<Locale>("test", locale);

		XmlBind<Locale> newXmlBind = xmlBind.toXml();

		assertEquals(xmlBind, newXmlBind);
	}

}
