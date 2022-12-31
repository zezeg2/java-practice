package practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MonthEmployee {
    ArrayList<String> getEmployees() {
        Connection con = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            Class.forName(ConnectionInform.DRIVER_CLASS);
            con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
            System.out.println("--- JDBC 드라이버 연결 성공");

            Scanner key = new Scanner(System.in);
            System.out.print("결과를 제외할 월 : ");
            int check = key.nextInt();
            System.out.println("입사월 - 급여총합");

            String sql =
                    "SELECT date_format(hire_date, '%m') as month, sum(salary) as total_salary " +
                            "FROM employees " +
                            "WHERE MONTH(hire_date) != ? " +
                            "GROUP BY MONTH(hire_date)";
            pt = con.prepareStatement(sql);
            pt.setInt(1, check);
            rs = pt.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                int total_salary = rs.getInt("total_salary");
                String data = month + "월 - " + total_salary + "원";
                list.add(data);
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
            } catch (SQLException ignored) {
            }
            System.out.println("--- JDBC 드라이버 연결 해제 성공 ---");
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> employees = new MonthEmployee().getEmployees();
        for (String e : employees) {
            System.out.println(e);
        }

    }
}
