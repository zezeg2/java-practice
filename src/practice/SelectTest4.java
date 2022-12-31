package practice;

import java.sql.*;

public class SelectTest4 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName(ConnectionInform.DRIVER_CLASS);
            con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
            System.out.println("----- JDBC 연결 성공 -----");

            st = con.createStatement();

            String sql = "show databases";
            sql = "describe employees";

            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getString(3)
                );
            }

        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 발견되지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ignored) {
            }
            System.out.println("----- JDBC 연결 해제 성공 -----");
        }

    }

}
