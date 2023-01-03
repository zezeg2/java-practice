package test.prob2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static test.prob2.ConnectionInform.*;


public class JDBCConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}