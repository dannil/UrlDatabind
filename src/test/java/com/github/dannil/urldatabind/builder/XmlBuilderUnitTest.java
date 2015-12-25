package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;

@RunWith(JUnit4.class)
public class XmlBuilderUnitTest {

	@Test
	public void generate() {
		IBuilder xmlBuilder = new XmlBuilder();

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		assertNotNull(xmlBuilder.generate(jsonBind));
	}

	@Test
	public void testHashCode() {
		IBuilder xmlBuilder = new XmlBuilder();

		assertEquals(Type.XML.hashCode(), xmlBuilder.hashCode());
	}
}
