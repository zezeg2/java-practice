package ch7.birds;
public class Sparrow extends Bird{
    String friend;
    public Sparrow(String name, int legs, int length, String friend) {
        super(name, legs, length);
        this.friend = friend;
    }
    @Override
    public void fly() {
        System.out.print("참새");
        super.fly();
    }
    @Override
    public void sing() {
        System.out.print("참새");
        super.sing();
    }
    @Override
    public void print() {
        System.out.print("참새의 ");
        super.print();
    }
    public void makeFriend(){
        System.out.println("참새의 친구는 " + this.friend +" 입니다");
    }
}