package ch7.board;

public class Board extends Information{
    private String content;
    private int viewCount;

    public Board(String id, String name, String content, int viewCount) {
        super(id, name);
        this.content = content;
        this.viewCount = viewCount;
    }

    @Override
    public String print() {
        return super.print() + String.format("%s : %d",content, viewCount);
    }
}
