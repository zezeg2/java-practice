package ch7.birds;

public class BirdRunner {
    public static void main(String[] args) {
        Duck duck = new Duck("오리색끼", 2, 12, 4);
        Sparrow sparrow = new Sparrow("참새색끼", 2, 12, "허수아비");

        duck.fly();
        duck.sing();
        duck.swim();
        duck.print();

        sparrow.fly();
        sparrow.sing();
        sparrow.makeFriend();
        sparrow.print();
    }
}
