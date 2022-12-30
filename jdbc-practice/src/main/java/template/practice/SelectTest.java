package template.practice;

import template.connection.JDBCConnection;

import java.sql.*;

public class SelectTest {

    public static void main(String[] args) {
        try (Connection con = JDBCConnection.getConnection();
             Statement st = con.createStatement()){

            String sql = "SELECT employee_id, first_name, last_name, salary, hire_date FROM employees";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2) + "-" + rs.getString(3);
                double salary = rs.getDouble("salary");
                Date d1 = rs.getDate("hire_date");        // 날짜 정보만 조회
                String d2 = rs.getString("hire_date");    // 날짜및 시간 정보를 모두 조회
                System.out.printf("사번:%d 이름:%s 급여:%.2f 입사일: %s \n", id, name, salary, d1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
