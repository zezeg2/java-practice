package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    String id;
    String pw;
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
    }

    public JDBCConnection() {
    }

    public JDBCConnection(String id, String pw) {
        this();
        this.id = id;
        this.pw = pw;
    }
}