package test.plob1;

public class Magazine extends Book {
    int month;

    public Magazine(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice, String bookPublisher, int month) {
        super(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
        this.month = month;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%10s%10s%20s%10s%10s",bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher,month);
    }
}
