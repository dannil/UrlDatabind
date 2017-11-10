package com.github.dannil.urldatabind.model.bind.result;

public class SQLResult implements Action {

    private String query;

    public SQLResult(String query) {
        this.query = query;
    }

    @Override
    public Object trigger() {
        return "sql";
    }

}
