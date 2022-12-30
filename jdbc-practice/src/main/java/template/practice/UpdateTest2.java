package template.practice;

import java.sql.*;
import java.util.Scanner;

import static template.connection.ConnectionInform.*;

public class UpdateTest2 {
	// 이전에 학습한 내용을 지우지 않기 위해서 새로 파일을 만듬
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName(DRIVER_CLASS);
			con =  DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			System.out.println("--- JDBC UPDATE TEST ---");
			
			Scanner key = new Scanner(System.in);
			System.out.print("사번 : ");
			int employee_id = key.nextInt();
			
			System.out.print("이름 : ");
			String name = key.next();
			String first_name = name.substring(1);
			String last_name = name.substring(0, 1);
			
			System.out.print("급여 인상 : ");
			double increase = key.nextDouble();

			String sql = "UPDATE emp_copy SET salary = salary + ?, first_name = ?, " +
					"last_name = ? WHERE employee_id = ?";

			PreparedStatement pt = con.prepareStatement(sql);
			pt.setDouble(1, increase);
			pt.setString(2, first_name);
			pt.setString(3, last_name);
			pt.setInt(4, employee_id);

			int rowcount = pt.executeUpdate();
			System.out.println("삽입 행의 개수 = " + rowcount);
			
		} catch (ClassNotFoundException e) {
			System.out.println("해당 드라이버가 발견되지 않습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();				
			} catch (SQLException e) {}
			System.out.println("연결 해제 성공");			
		}
		
	}

}
