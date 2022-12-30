package template.practice;

import template.connection.ConnectionInform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con =  DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			System.out.println("연결 성공");
			Statement st = con.createStatement();
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
			String sql = """
					UPDATE emp_copy
					SET salary = salary + %d , first_name =  %s, last_name = %s 
					WHERE employee_id = %s;
					""".formatted(increase, first_name, last_name, employee_id);
			
			int rowcount = st.executeUpdate(sql);
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
