package practice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args) {
        Connection con = null;
        try {
            // 0. JDBC Driver 호출
            Class.forName(ConnectionInform.DRIVER_CLASS);
            // 1. DB 연결
            con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);

            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 발견되지 않습니다.");
        } catch (SQLException e) {
            System.out.println("DB 연결 정보를 확인하세요.");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
            System.out.println("연결 해제 성공");
        }

    }

}
