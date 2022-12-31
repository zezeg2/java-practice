package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName(ConnectionInform.DRIVER_CLASS);
			con =  DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
			System.out.println("연결 성공");
//			System.out.println(con.getAutoCommit());	자동커밋 여부 확인
			
			Statement st = con.createStatement();
//			String sql = "INSERT INTO emp_copy VALUES(400, '길동', '홍', 1000, now(), 50)";
			
			Scanner key = new Scanner(System.in);
			System.out.print("상품명 : ");
			String p_name = key.nextLine();
			
			System.out.print("가격 : ");
			int price = key.nextInt();
			
			System.out.print("수량 : ");
			int balance = key.nextInt();
			
			String sql = "INSERT INTO product(p_name, price, balance) "
					+ "VALUES ('" + p_name + "'," + price + "," + balance + ")";
			
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
