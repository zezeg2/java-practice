package ch6;

public class OOPChapterRunner {
    public static void main(String[] args) {
//        Trainee trainee = new Trainee("henry", "Spring", 200000);
//        trainee.calc();
//        System.out.println(trainee.getRefund());
//        System.out.println(trainee);

        Member member = new Member();
        member.insert("Hello", 1234, "Jery", 28);
        member.login("Helo", 1234);
        member.login("Hello", 12345);
        member.login("Hello", 1234);
        member.getMyInfo();
        System.out.println(member.logout());
    }
}
