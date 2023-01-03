package test.prob2;

import java.sql.SQLException;
import java.util.Scanner;

public class BookTest {

    static BookDAO bookDAO = BookDAO.getInstance();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        String bookNo = nextString("bookNo : ");
        String bookTitle = nextString("bookTitle : ");
        String bookAuthor = nextString("bookAuthor : ");
        String bookTime = nextString("bookTime : ");
        String bookPrice = nextString("bookPrice : ");
        String bookPublisher = nextString("bookPublisher : ");

        BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, String.format("%s-00-00 00:00:00",bookTime) , Integer.parseInt(bookPrice), bookPublisher);
        bookDAO.insertBook(bookDTO);
        bookDAO.selectBook();
    }

    public static String nextString(String comment) {
        System.out.print(comment);
        return sc.next();
    }
}
