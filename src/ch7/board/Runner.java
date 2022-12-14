package ch7.board;

public class Runner {
    public static void main(String[] args) {
        InformationList list = new InformationList(6);//
        list.add(new Board("1", "게시물1", "현재 조회수 10입니다", 10));
        list.add(new Product("100", "웅진비데", 300000));
        list.add(new Member("hong", "홍길동", "hong@a.com", "010-222-2222"));
        list.add(new Board("2", "게시물2", "새로운 게시물 추가합니다.", 0));
        list.add(new Product("200", "웅진정수기", 1000000));
        list.add(new Member("lee", "이철수", "chul@b.com", "010-333-3333"));
        list.read();
    }
}
