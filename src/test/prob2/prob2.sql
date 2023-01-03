drop table book;

create table book
(
    bookNo       char(10) primary key,
    bookTitle    varchar(30),
    bookAuthor   varchar(20),
    bookTime     datetime,
    bookPrice    int,
    bookPublisher char(10)
);

insert into book (bookNo, bookTitle, bookAuthor, bookTime, bookPrice, bookPublisher)
VALUES ('B001', '자바프로그래밍', '홍길동', date_format('2021-00-00 00:00:00','%y/%c/%e') , 30000, '서울출판사'),
       ('B002', '데이터베이스', '이몽룡', date_format('2020-00-00 00:00:00','%y/%c/%e'), 25000, '대한출판사'),
       ('B003', 'HTML/CSS', '성춘향', date_format('2021-00-00 00:00:00','%y/%c/%e'), 18000, '민국출판사');

select bookNo, bookTitle, bookAuthor, date_format(bookTime, '%Y'), bookPrice, bookPublisher from book;

