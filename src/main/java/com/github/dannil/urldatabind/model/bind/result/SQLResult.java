/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.urldatabind.model.bind.result;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>Result class which accepts an SQL prepared statement.</p>
 *
 * @since 0.1.0
 */
public class SQLResult implements Action {

    private PreparedStatement statement;

    /**
     * <p>Default constructor.</p>
     *
     * @param statement
     *            the statement
     */
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
