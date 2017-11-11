package com.github.dannil.urldatabind;

import java.util.HashSet;
import java.util.Set;

import com.github.dannil.urldatabind.deprecated.SQLBind;
import com.github.dannil.urldatabind.http.BindHttpServer;
import com.github.dannil.urldatabind.model.Person;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.AbstractBind;
import com.github.dannil.urldatabind.model.bind.JsonBind;
import com.github.dannil.urldatabind.model.bind.XmlBind;
import com.github.dannil.urldatabind.model.bind.result.ObjectResult;
import com.github.dannil.urldatabind.model.bind.result.SQLResult;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        SQLResult sqlResult = new SQLResult("SELECT * FROM test");
//        JsonBind jsonBind = new JsonBind("test/abc", RequestMethod.GET, sqlResult);
//        System.out.println(jsonBind.getHttpContent());

        
        
        Person person = new Person("Daniel", "Nilsson");
        ObjectResult objectResult = new ObjectResult(person);
        
        JsonBind jsonBind2 = new JsonBind("person/daniel/json", RequestMethod.GET, objectResult);
        XmlBind xmlBind = new XmlBind("person/daniel/xml", RequestMethod.GET, objectResult);
        
        Set<AbstractBind> binds = new HashSet<AbstractBind>();
        binds.add(jsonBind2);
        binds.add(xmlBind);
        
        BindHttpServer server = new BindHttpServer(binds);
        server.start(5433);
    }

}
