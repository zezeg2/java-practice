package template.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static template.connection.ConnectionInform.*;

public class MyConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
