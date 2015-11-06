package com.github.dannil.urldatabind.model.json;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public interface IBindUnitTest {

	void createWithConstructor();

	void getPath();

	void setPath();

	void getContent();

	void setContent();

	void getHttpContent();

	void getType();

	void getHttpType();

	void toJson();

	void toXml();

}
