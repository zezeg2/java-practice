package ch13;

import java.util.stream.IntStream;

public class ThreadB implements Runnable{
    @Override
    public void run() {
        IntStream.range(10,20).forEach(System.out::println);
    }
}
