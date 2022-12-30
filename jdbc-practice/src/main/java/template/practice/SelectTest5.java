package template.practice;

import java.sql.*;
import java.util.Scanner;

import static template.connection.ConnectionInform.*;

public class SelectTest5 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(DRIVER_CLASS);
			con =  DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("연결 성공");
			st = con.createStatement();

			/*
			  employees 테이블에서 사원명(first_name)을 입력해서 다음과 같은 형식으로 결과를 조회하라.
			  사원명 부서명 도시명
			  만약 부서명, 도시명이 null 이라면
			  부서명 -> '부서이동중'으로 출력, 도시명-> '이사중'으로 변경하여 출력
			 */

			Scanner key = new Scanner(System.in);
			System.out.print("사원명 : ");
			String first_name = key.nextLine();

			String sql =
					"SELECT first_name, IFNULL(department_name, '부서이동중') as department_name, IFNULL(city, '이사중') as city " +
					"FROM employees e " +
					"LEFT JOIN departments d ON e.department_id = d.department_id " +
					"LEFT JOIN locations l ON l.location_id = d.location_id " +
					"WHERE first_name = '" + first_name +"'";
			rs = st.executeQuery(sql);

			int line = 0;
			while (rs.next()) {
				++line;
				String name = rs.getString("first_name");
				String department_name = rs.getString("department_name");
				String city = rs.getString("city");
				System.out.printf("%d번-사원명:%s, 부서명:%s, 도시명:%s\n", line, name, department_name, city);
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
			} catch (SQLException e) {}
			System.out.println("연결 해제 성공");			
		}
		
	}

}
