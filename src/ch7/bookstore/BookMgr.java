package ch7.bookstore;
import java.util.Arrays;
public class BookMgr {
    Book[] bookList;
    public BookMgr(Book[] bookList) {
        this.bookList = bookList;
    }
    public void printBookList() {
        Arrays.stream(bookList).map(book -> book.getTitle()).forEach(System.out::println);
    }
    public void printTotalPrice() {
        System.out.println(Arrays.stream(bookList).mapToInt(book -> book.getPrice()).sum());
    }
}