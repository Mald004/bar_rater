package persistence;

import junit.framework.TestCase;

import java.sql.SQLException;

import control.ConnectionPool;

public class UserMapperTest extends TestCase {
ConnectionPool connectionPool;
    private static String USER = "root";
    private static String PASSWORD = "123m";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/bar_rater_test";
    public void setUp() throws Exception {
        super.setUp();
        connectionPool = new ConnectionPool(USER,PASSWORD,URL);
    }

    public void testInsertUser() throws SQLException {
        int id = UserMapper.insertUser(connectionPool,2,"Malo","123");
        System.out.println(id);
    }
}