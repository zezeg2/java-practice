package ch13;

import java.util.stream.IntStream;

public class ThreadA extends Thread{
    @Override
    public void run() {
        IntStream.range(0,10).forEach(System.out::println);
    }
}
