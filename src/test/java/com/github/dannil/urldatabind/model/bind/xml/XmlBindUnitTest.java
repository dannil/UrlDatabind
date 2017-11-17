package com.github.dannil.urldatabind.model.bind.xml;

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
import com.github.dannil.urldatabind.model.bind.XmlBind;
import com.github.dannil.urldatabind.model.bind.result.Action;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;
import com.github.dannil.urldatabind.test.model.IBindUnitTest;
import com.github.dannil.urldatabind.test.model.IEqualsUnitTest;

@RunWith(JUnit4.class)
public class XmlBindUnitTest implements IBindUnitTest, IEqualsUnitTest {

    @Test
    @Override
    public void createWithConstructor() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertNotNull(bind);
    }

    @Test
    @Override
    public void getPath() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertEquals("test", bind.getPath());
    }

    @Test
    @Override
    public void setPath() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        bind.setPath("setTest");

        assertEquals("setTest", bind.getPath());
    }

    @Test
    @Override
    public void getRequestMethod() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertEquals(RequestMethod.GET, bind.getRequestMethod());
    }

    @Test
    @Override
    public void setRequestMethod() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        bind.setRequestMethod(RequestMethod.POST);

        assertEquals(RequestMethod.POST, bind.getRequestMethod());
    }

//    @Test
//    @Override
//    public void getContent() {
//        Locale locale = new Locale("en", "US");
//        AbstractBind<Locale> bind = new XmlBind<Locale>("test", RequestMethod.GET, locale);
//
//        assertEquals(locale.getCountry(), bind.getHttpContent().getCountry());
//    }

//    @Test
//    @Override
//    public void setContent() {
//        Locale locale = new Locale("en", "US");
//        AbstractBind<Locale> bind = new XmlBind<Locale>("test", RequestMethod.GET, locale);
//
//        Locale newLocale = new Locale("sv", "SE");
//        bind.setContent(newLocale);
//
//        assertEquals("SE", bind.getHttpContent().getCountry());
//    }

    @Test
    @Override
    public void getHttpContent() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<locale>en_US</locale>", bind.getHttpContent());
    }

    @Test
    @Override
    public void getType() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertEquals(Type.XML, bind.getType());
    }

    @Test
    @Override
    public void getHttpType() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        assertEquals("application/xml", bind.getHttpType());
    }

    @Test
    @Override
    public void toJson() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        AbstractBind newBind = bind.toJson();

        assertNotEquals(bind.getHttpContent(), newBind.getHttpContent());
        assertEquals(bind.getPath(), newBind.getPath());
        assertEquals(Type.JSON, newBind.getType());
    }

    @Test
    @Override
    public void toPlain() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        AbstractBind newBind = bind.toPlain();

        assertNotEquals(bind.getHttpContent(), newBind.getHttpContent());
        assertEquals(bind.getPath(), newBind.getPath());
        assertEquals(Type.PLAIN, newBind.getType());
    }

    @Test
    @Override
    public void toXml() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind bind = new XmlBind("test", RequestMethod.GET, action);

        AbstractBind newBind = bind.toXml();

        assertEquals(bind, newBind);
    }

    @Test
    @Override
    public void equals() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);
        AbstractBind b2 = new XmlBind("test", RequestMethod.GET, action);

        assertEquals(b1, b2);
    }

    @Test
    @Override
    public void equalsItself() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);

        assertEquals(b1, b1);
    }

    @Test
    @Override
    public void notEqualsNull() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);
        AbstractBind b2 = null;

        assertNotEquals(b1, b2);
    }

    @Test
    @Override
    public void notEqualsIncompatibleObject() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);

        assertNotEquals(b1, locale);
    }
	
    @Test
    public void notEqualsPath() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);
        AbstractBind b2 = new XmlBind("test2", RequestMethod.GET, action);

        assertNotEquals(b1, b2);
    }

    @Test
    public void notEqualsRequestMethod() {
        Locale locale = new Locale("en", "US");
        Action action = new ObjectResult(locale);
        AbstractBind b1 = new XmlBind("test", RequestMethod.GET, action);
        AbstractBind b2 = new XmlBind("test1", RequestMethod.POST, action);

        assertNotEquals(b1, b2);
    }

}
