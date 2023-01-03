package test.plob1;

import java.util.Arrays;

public class Problem1Runner {
    public static void main(String[] args) {
        Book[] books = new Book[6];
        books[0] = new Book("B001", "자바프로그래밍", "홍길동", 2021, 30000, "서울출판사");
        books[1] = new Book("B002", "데이터베이스", "이몽룡", 2020, 25000, "대한출판사");
        books[2] = new Book("B003", "HTML/CSS", "성춘향", 2022, 18000, "민국출판사");
        books[3] = new Magazine("M001", "자바 월드", "홍길동", 2021, 3000, "서울출판사", 5);
        books[4] = new Magazine("M002", "웹 월드", "이몽룡", 2021, 2500, "서울출판사", 7);
        books[5] = new Magazine("M003", "게임 월드", "성춘향", 2022, 1800, "서울출판사", 9);

        System.out.println(String.format("%s%20s%10s%10s%20s%10s%10s","도서번호", "도서명", "저자", "출판년도", "가격", "출판사","발행월"));
        Arrays.stream(books).forEach(System.out::println);
    }
}
