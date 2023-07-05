package persistenceMYSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import control.ConnectionPool;

public class ReviewMapper {

    public static void sendReview(ConnectionPool connectionPool, int id, String name, String address, ArrayList<Integer> ratings) throws SQLException {
        String sql = "INSERT INTO review (navn, addresse, crowded, hyggelig, lokation, plads, musik, alders_gennemsnit, kan_se_sport, spil, ølvarianter, charme, typer, øl_pris, shot_pris, drink_pris, user_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql)) {

            pre.setString(1, name);
            pre.setString(2, address);
            pre.setInt(3, ratings.get(0));
            pre.setInt(4, ratings.get(1));
            pre.setInt(5, ratings.get(2));
            pre.setInt(6, ratings.get(3));
            pre.setInt(7, ratings.get(4));
            pre.setInt(8, ratings.get(5));
            pre.setInt(9, ratings.get(6));
            pre.setInt(10, ratings.get(7));
            pre.setInt(11, ratings.get(8));
            pre.setInt(12, ratings.get(9));
            pre.setInt(13, ratings.get(10));
            pre.setInt(14, ratings.get(11));
            pre.setInt(15, ratings.get(12));
            pre.setInt(16, ratings.get(13));
            pre.setInt(17, id);

            pre.executeUpdate();
        }
    }


}
