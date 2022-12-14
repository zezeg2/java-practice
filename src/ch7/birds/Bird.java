package ch7.birds;
public class Bird {
    protected String name;
    protected int legs;
    protected int length;
    public Bird(String name, int legs, int length) {
        this.name = name;
        this.legs = legs;
        this.length = length;
    }
    public void fly(){
        System.out.println("("+this.name+")" + "가 날아다닙니다");
    }
    public void sing(){
        System.out.println("("+this.name+")" + "가 소리내어 웁니다");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("이름은 " + this.name + " 입니다.");
    }
}
