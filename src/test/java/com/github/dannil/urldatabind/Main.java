package com.github.dannil.urldatabind;

import java.time.ZonedDateTime;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.JsonBind;
import com.github.dannil.urldatabind.model.bind.XmlBind;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;

public class Main {

    public static void main(String[] args) {
        // SQLResult sqlResult = new SQLResult("SELECT * FROM test");
        // JsonBind jsonBind = new JsonBind("test/abc", RequestMethod.GET, sqlResult);
        // System.out.println(jsonBind.getHttpContent());

        ZonedDateTime dt = ZonedDateTime.now();
        ObjectResult objectResult = new ObjectResult(dt);

        JsonBind jsonBind2 = new JsonBind("person/daniel/json", RequestMethod.GET, objectResult);
        XmlBind xmlBind = new XmlBind("person/daniel/xml", RequestMethod.GET, objectResult);
    }

}
