package persistenceMYSQL;

import java.sql.SQLException;

import control.ConnectionPool;

public class UserFacade {
    public static void insertUser(ConnectionPool connectionPool,int age,  String username, String password) throws SQLException {
        UserMapper.insertUser(connectionPool,age,username,password);
    }
}
