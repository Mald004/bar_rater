package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.ConnectionPool;

public class UserMapper {

    public static int insertUser(ConnectionPool connectionPool, int age, String username, String password) throws SQLException {
        String sql = "INSERT INTO user (age, name, password) VALUES (?, ?, ?)";
        int generatedKey = 0;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
        }

        return generatedKey;
    }


}
