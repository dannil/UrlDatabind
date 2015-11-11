package com.github.dannil.urldatabind.model.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void getType() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void getHttpType() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void toJson() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Override
	public void toXml() {
		// TODO Auto-generated method stub
		
	}

}
