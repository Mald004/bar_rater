package persistenceMYSQL;

import java.sql.SQLException;
import java.util.ArrayList;

import control.ConnectionPool;

public class ReviewFacade {
    public static void sendReview(ConnectionPool connectionPool, int id, String name, String address, ArrayList<Integer> ratings) throws SQLException {
        ReviewMapper.sendReview(connectionPool,id,name,address,ratings);
    }
}
