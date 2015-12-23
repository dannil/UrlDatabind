package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.bind.json.JsonBind;

@RunWith(JUnit4.class)
public class FormatBuilderUnitTest {

	@Test
	public void getInstance() {
		FormatBuilder formatBuilder = FormatBuilder.getInstance();

		assertNotEquals(null, formatBuilder);
	}

	@Test
	public void getHttpFormat() {
		FormatBuilder formatBuilder = FormatBuilder.getInstance();

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		assertEquals("\"en_US\"", formatBuilder.getHttpFormat(jsonBind.getType(), jsonBind));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getHttpFormatInvalidType() {
		FormatBuilder formatBuilder = FormatBuilder.getInstance();

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", locale);

		formatBuilder.getHttpFormat(null, jsonBind);
	}
}
