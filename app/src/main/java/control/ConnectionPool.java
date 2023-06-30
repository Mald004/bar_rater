package control;


import android.util.Log;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool
{

    private HikariDataSource ds;
    private static String USER = "root";
    private static String PASSWORD = "123m";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/bar_rater";
    private static ConnectionPool instance;



    private ConnectionPool() {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            USER = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
            URL = System.getenv("JDBC_CONNECTION_STRING");

        }
    }

    public ConnectionPool(String USER, String PASSWORD, String URL)
    {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null)
        {
            // Prod: hent variabler fra setenv.sh i Tomcats bin folder
            USER = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
            URL = System.getenv("JDBC_CONNECTION_STRING");
        }

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(5);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        this.ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }

    public void close()
    {
        ds.close();
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            Log.d("DEBUG", "Creating new instance of ConnectionPool");
            instance = new ConnectionPool();
        } else {
            Log.d("DEBUG", "Returning existing instance of ConnectionPool");
        }
        return instance;
    }

}
