package com.github.dannil.urldatabind.test.model;

public interface IBindTest {

    void createWithConstructor();

    void getPath();

    void setPath();

    void getRequestMethod();

    void setRequestMethod();

    //void getContent();

    //void setContent();

    void getHttpContent();

    void getType();

    void getHttpType();

    void toJson();

    void toPlain();

    void toXml();

}
