package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static connection.ConnectionInform.*;

public class JDBCConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Objects.requireNonNull(Class.forName(ConnectionInform.DRIVER_CLASS));

        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}