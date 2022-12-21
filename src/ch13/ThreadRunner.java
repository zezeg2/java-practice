package ch13;

public class ThreadRunner {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        new Thread(threadB).start();
        System.out.println("main");
    }
}
