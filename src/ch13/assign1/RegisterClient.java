package ch13.assign1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterClient extends Thread{
    private Date date;

    public RegisterClient(Date date) {
        this.date = date;
    }
    @Override
    public void run() {
        DateFormat format = new SimpleDateFormat("yyyy년도 MM월 dd일에 회원가입요청받았습니다");
        System.out.println(format.format(date));
        System.out.println("회원가입요청 처리중입니다");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("회원가입요청 처리완료 입니다");
    }
}
