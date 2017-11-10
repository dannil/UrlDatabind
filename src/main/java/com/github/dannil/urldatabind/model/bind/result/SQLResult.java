package com.github.dannil.urldatabind.model.bind.result;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLResult implements Action {

    private PreparedStatement statement;

    public SQLResult(PreparedStatement statement) {
        this.statement = statement;
    }

    @Override
    public Object trigger() {
        // TODO TEST CODE! Fix and add resource handling
        try {
            return this.statement.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
