package template.practice;

import java.sql.*;

import static template.connection.ConnectionInform.*;

public class SelectTest2 {
    // Statement -> PreparedStatement 로 변경하면서 기존의 Statement 는 삭제
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("연결 성공");

            String sql = "SELECT user_id, address FROM users WHERE address like ?";
            pt = con.prepareStatement(sql);
            pt.setString(1, "%용산구%");
            rs = pt.executeQuery();

            int line = 0;
            while (rs.next()) {
                ++line;
                String user_id = rs.getString("user_id");
                String address = rs.getString("address");

                System.out.printf("%d번- 아이디:%s, 주소:%s\n", line, user_id, address);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 발견되지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pt.close();
                con.close();
            } catch (SQLException e) {
            }
            System.out.println("연결 해제 성공");
        }

    }

}
