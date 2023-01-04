package connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static DataSource source;

    public static DataSource getSource() throws  NamingException {
        if (source == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            source = (DataSource) envContext.lookup("jdbc/mydb");
        }

        return source;
    }
}