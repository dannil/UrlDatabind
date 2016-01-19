package com.github.dannil.urldatabind.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.Type;
import com.github.dannil.urldatabind.model.bind.json.JsonBind;
import com.github.dannil.urldatabind.test.model.IEqualsUnitTest;

@RunWith(JUnit4.class)
public class PlainBuilderUnitTest implements IEqualsUnitTest {

	@Test
	public void generate() {
		IBuilder plainBuilder = new PlainBuilder();

		Locale locale = new Locale("en", "US");
		JsonBind<Locale> jsonBind = new JsonBind<Locale>("test", RequestMethod.GET, locale);

		assertNotNull(plainBuilder.generate(jsonBind));
	}

	@Test
	public void testHashCode() {
		IBuilder plainBuilder = new PlainBuilder();

		assertEquals(Type.PLAIN.hashCode(), plainBuilder.hashCode());
	}

	@Test
	@Override
	public void equals() {
		IBuilder b1 = new PlainBuilder();
		IBuilder b2 = new PlainBuilder();

		assertEquals(b1, b2);
	}

	@Test
	@Override
	public void equalsItself() {
		IBuilder b1 = new PlainBuilder();

		assertEquals(b1, b1);
	}

	@Test
	@Override
	public void notEqualsNull() {
		IBuilder b1 = new PlainBuilder();

		assertNotEquals(b1, null);
	}

	@Test
	@Override
	public void notEqualsIncompatibleObject() {
		IBuilder b1 = new PlainBuilder();

		assertNotEquals(b1, new Object());
	}
}
