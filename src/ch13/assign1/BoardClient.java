package ch13.assign1;

import java.util.Date;

public class BoardClient extends Thread{
    @Override
    public void run() {
        int count = 0;
        while (true){
            System.out.println(String.format("게시물 %d번 작성합니다",++count));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}