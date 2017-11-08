package com.github.dannil.urldatabind;

import com.github.dannil.urldatabind.model.RequestMethod;
import com.github.dannil.urldatabind.model.bind.sql.SQLBind;
import com.github.dannil.urldatabind.model.bind.sql.SQLResult;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        SQLResult sqlResult = new SQLResult("SELECT * FROM test");
        SQLBind sqlBind = new SQLBind("test/abc", RequestMethod.GET, sqlResult);
        sqlBind.transformResult();

    }

}
