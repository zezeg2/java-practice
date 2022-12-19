package ch9;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StringBufferTest {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(() -> {
            int count = 0;
            while (count < 20){
//                stringBuffer.append("a");
                stringBuilder.append("a");
                count++;
            }
        });

        service.execute(() -> {
            int count = 0;
            while (count < 20){
//                stringBuffer.append("b");
                stringBuilder.append("b");
                count++;
            }
        });

        service.execute(() -> {
            int count = 0;
            while (count < 20){
//                stringBuffer.append("b");
                stringBuilder.append("c");
                count++;
            }
        });

        service.execute(() -> {
            int count = 0;
            while (count < 20){
//                stringBuffer.append("b");
                stringBuilder.append("d");
                count++;
            }
        });

        if (service.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println(LocalTime.now() + " All jobs are terminated");
        } else {
            System.out.println(LocalTime.now() + " some jobs are not terminated");
            service.shutdownNow();
        }

        System.out.println(stringBuilder);

        System.out.println("end");
    }
}
