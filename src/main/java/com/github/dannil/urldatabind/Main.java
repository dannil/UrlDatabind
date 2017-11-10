package com.github.dannil.urldatabind;

import com.github.dannil.urldatabind.deprecated.SQLBind;
import com.github.dannil.urldatabind.model.Person;
import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.JsonBind;
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
        JsonBind jsonBind2 = new JsonBind("person/daniel", RequestMethod.GET, objectResult);
        System.out.println(jsonBind2.getHttpContent());
        
        
    }

}
