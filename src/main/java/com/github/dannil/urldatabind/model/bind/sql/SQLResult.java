package com.github.dannil.urldatabind.model.bind.sql;

import com.github.dannil.urldatabind.model.Result;

public class SQLResult implements Result {

    private String query;

    public SQLResult(String query) {
        this.query = query;
    }

    @Override
    public Object generate() {
        return "sql";
    }

}
