package test.prob2;

import java.sql.*;

public class BookDAO {
    private static BookDAO instance;
    private BookDAO(){
    }
    public static BookDAO getInstance(){
        if (instance==null) instance = new BookDAO();
        return instance;
    }
    public void insertBook(BookDTO bookDTO) throws SQLException {
        String sql = "insert into book (bookNo, bookTitle, bookAuthor, bookTime, bookPrice, bookPublisher) VALUES (?,?,?,date_format(?,'%y/%c/%e'),?,?)";
        try(Connection con = JDBCConnection.getConnection();
            PreparedStatement pt = con.prepareStatement(sql)){
            pt.setString(1, bookDTO.getBookNo());
            pt.setString(2, bookDTO.getBookTitle());
            pt.setString(3, bookDTO.getBookAuthor());
            pt.setString(4, bookDTO.getBookTime());
            pt.setInt(5, bookDTO.getBookPrice());
            pt.setString(6, bookDTO.getBookPublisher());
            pt.executeQuery();
        }
    }
    public void selectBook() throws SQLException {
        String sql = "select bookNo, bookTitle, bookAuthor, date_format(bookTime, '%Y'), bookPrice, bookPublisher from book";
        try(Connection con = JDBCConnection.getConnection();
            Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()){
                sb.append(rs.getString(1)).append("\t")
                        .append(rs.getString(2)).append("\t")
                        .append(rs.getString(3)).append("\t")
                        .append(rs.getString(4)).append("\t")
                        .append(rs.getString(5)).append("\t")
                        .append(rs.getString(6)).append("\t").append("\n");
            }
            System.out.println(sb);
        }
    }
}
