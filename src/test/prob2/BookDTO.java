package test.prob2;

public class BookDTO {
    private String bookNo;
    private String bookTitle;
    private String bookAuthor;
    private String bookTime;
    private int bookPrice;
    private String bookPublisher;

    public BookDTO(String bookNo, String bookTitle, String bookAuthor, String bookTime, int bookPrice, String bookPublisher) {
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookTime = bookTime;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
    }

    public String getBookNo() {
        return bookNo;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookTime() {
        return bookTime;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }
}
