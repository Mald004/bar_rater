package persistenceMYSQL;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.ConnectionPool;

public class ReviewMapperTest extends TestCase {
    private ConnectionPool connectionPool;
    private ArrayList<Integer> ratings;
    private static String USER = "root";
    private static String PASSWORD = "123m";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/bar_rater_test";
    private int id;

    public void setUp() throws Exception {
        super.setUp();
        connectionPool = new ConnectionPool(USER,PASSWORD,URL);
        ratings = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            int rating = i;
            ratings.add(rating);
        }

        id = UserMapper.insertUser(connectionPool,2,"tester","123");

        try (Connection connection = connectionPool.getConnection(); Statement statement = connection.createStatement()) {
            String deleteSql = "DELETE FROM user WHERE id = " + id;
            statement.execute(deleteSql);
        }
    }

    public void testSendReview() throws SQLException {
        ReviewMapper.sendReview(connectionPool, id, "ølsted", "ølstedadres", ratings);
    }
}