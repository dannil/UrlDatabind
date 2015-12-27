package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;

@RunWith(JUnit4.class)
public class JsonBuilderUnitTest {

	@Test
	public void generate() {
		IBuilder jsonBuilder = new JsonBuilder();

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotNull(jsonBuilder.generate(jsonBind));
	}

	@Test
	public void testHashCode() {
		IBuilder jsonBuilder = new JsonBuilder();

		assertEquals(Type.JSON.hashCode(), jsonBuilder.hashCode());
	}
}
