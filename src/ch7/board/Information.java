package ch7.board;

public class Information {
    protected String id;
    protected String name;

    public Information(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String print(){
        return String.format("%s : %s : ",id,name);
    }
}
