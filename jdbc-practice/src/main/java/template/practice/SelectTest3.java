package template.practice;

import java.sql.*;

import static template.connection.ConnectionInform.*;

public class SelectTest3 {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("JDBC 연결 성공");

            st = con.createStatement();
            //String sql = "create table maxtest(a int)"; // JDBC SQL - Create table이 가능하지만 권고 X
            //int rowcount = st.executeUpdate(sql);
            //System.out.println(rowcount);

            String sql = "select max(a) from maxtest";
            rs = st.executeQuery(sql);    // rs 이전위치
//			while (rs.next()) {			// next() 호출후 첫 번째 위치로 이동
//				System.out.println(rs.getInt("a"));
//			}
            rs.next();
            if (rs.getString("max(a)") != null) {
                System.out.println("최대값 = " + rs.getString("max(a)"));
            } else {
                System.out.println("최대값 = 0");
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
            System.out.println("JDBC 연결 해제 성공");
        }

    }

}
