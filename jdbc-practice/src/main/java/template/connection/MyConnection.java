package template.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import static template.connection.ConnectionInform.*;

public class MyConnection {
    public static Connection getConnection() {
        try  {
            Connection con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("연결 성공");
            return con;
        } catch (Exception e) {
            System.out.println("연결 실패");
            return null;
        }
    }
}
