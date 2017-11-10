package com.github.dannil.urldatabind.model.bind.sql;

import com.github.dannil.urldatabind.model.Action;

public class SQLResult implements Action {

    private String query;

    public SQLResult(String query) {
        this.query = query;
    }

    @Override
    public Object generate() {
        return "sql";
    }

}
