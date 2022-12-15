package ch8.practice2;

public class MySum {
    private int first;
    private int second;
    MySum (int first, int second){
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return String.valueOf(first + second);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MySum input)) return false;
        return input.toString().equals(this.toString());
    }
}
