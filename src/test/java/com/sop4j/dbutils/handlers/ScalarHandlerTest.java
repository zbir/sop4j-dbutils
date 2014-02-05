/*
 * Copyright (C) 2014 SOP4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sop4j.dbutils.handlers;

import java.sql.SQLException;

import com.sop4j.dbutils.BaseTestCase;
import com.sop4j.dbutils.ResultSetHandler;

public class ScalarHandlerTest extends BaseTestCase {

    public void testHandle() throws SQLException {
        ResultSetHandler<String> h = new ScalarHandler<String>();
        Object results = h.handle(this.rs);
        assertNotNull(results);
        assertEquals("1", results);
    }

    public void testColumnIndexHandle() throws SQLException {
        ResultSetHandler<String> h = new ScalarHandler<String>(2);
        Object results = h.handle(this.rs);
        assertNotNull(results);
        assertEquals("2", results);
    }

    public void testColumnNameHandle() throws SQLException {
        ResultSetHandler<Integer> h = new ScalarHandler<Integer>("intTest");
        Object results = h.handle(this.rs);
        assertNotNull(results);
        assertEquals(Integer.valueOf(1), results);
    }

    public void testEmptyResultSetHandle() throws SQLException {
        ResultSetHandler<String> h = new ScalarHandler<String>();
        Object results = h.handle(this.emptyResultSet);
        assertNull(results);
    }

}
