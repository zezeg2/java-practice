package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest2 {
    // 이전에 학습한 내용을 지우지 않기 위해서 새로 파일을 만듬
    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName(ConnectionInform.DRIVER_CLASS);
            con = DriverManager.getConnection(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
            System.out.println("연결 성공");

            Scanner key = new Scanner(System.in);
            System.out.print("상품명 : ");
            String p_name = key.nextLine();

            System.out.print("가격 : ");
            int price = key.nextInt();

            System.out.print("수량 : ");
            int balance = key.nextInt();

//			Statement st = con.createStatement();
//			String sql = "INSERT INTO product(p_name, price, balance) "
//					+ "VALUES ('" + p_name + "'," + price + "," + balance + ")";
//			int rowcount = st.executeUpdate(sql);

            String sql = "INSERT INTO product(p_name, price, balance) VALUES (?, ?, ?)";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, p_name);
            pt.setInt(2, price);
            pt.setInt(3, balance);
            int rowcount = pt.executeUpdate();

            System.out.println("삽입 행의 개수 = " + rowcount);

        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 발견되지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
            System.out.println("연결 해제 성공");
        }

    }

}
