package ch7.birds;

public class Duck extends Bird{
    private int web;
    public Duck(String name, int legs, int length, int web) {
        super(name, legs, length);
        this.web = web;
    }
    @Override
    public void fly() {
        System.out.println("오리("+this.name+")" + "는 날지 않습니다");
    }
    @Override
    public void sing() {
        System.out.print("오리");
        super.sing();
    }
    @Override
    public void print() {
        System.out.print("오리의 ");
        super.print();
    }
    public void swim(){
        System.out.println("오리" + "(" + this.name + ")가 " + this.web + "개의 물갈퀴로 수영합니다.");
    }
}