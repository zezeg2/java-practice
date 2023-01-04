package connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static connection.ConnectionInform.*;

public class JDBCConnection {
    private static DataSource source;

    public static DataSource getSource() throws SQLException, ClassNotFoundException, NamingException {
        Objects.requireNonNull(Class.forName(ConnectionInform.DRIVER_CLASS));
        if (source == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            source = (DataSource) envContext.lookup("jdbc/mydb");
        };

        return source;
    }
}