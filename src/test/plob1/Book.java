package test.plob1;

public class Book {
    String bookNo;
    String bookTitle;
    String bookAuthor;


    int bookYear;
    int bookPrice;
    String bookPublisher;

    public Book(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice, String bookPublisher) {
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%10s%10s%20s%10s",bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
    }
}
