package servlets.test;

import connection.DataSourceProvider;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static connection.ConnectionInform.*;

@WebServlet("/source-test")
public class ConnectionPoolTestServlet extends HttpServlet {
    private DataSource source;

    @Override
    public void init() throws ServletException {
        try {
            source = DataSourceProvider.getSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long withPoolStart = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            try(Connection con = source.getConnection()){

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        long withPoolEnd = System.currentTimeMillis();
        System.out.println("with Pool diff : " + (withPoolEnd - withPoolStart) + "ms");
        long withoutPoolStart = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++){
            try(Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);) {
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        long withoutPoolEnd = System.currentTimeMillis();

        System.out.println("without Pool Diff : " + (withoutPoolEnd - withoutPoolStart) + "ms");
    }
}
