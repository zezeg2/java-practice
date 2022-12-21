package ch13.assign1;

public class LoginClient extends Thread {
    private String id;
    private String pw;

    public LoginClient(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    @Override
    public void run() {
        System.out.println(String.format("로그인아이디 %s를 입력받습니다",id));
        System.out.println("로그인 암호를 확인합니다");
        if (pw.equals("java")) System.out.println("로그인 암호가 맞습니다");
        else System.out.println("로그인 암호가 올바르지 않습니다");
    }
}
