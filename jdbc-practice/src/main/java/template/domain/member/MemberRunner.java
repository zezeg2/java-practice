package template.domain.member;

import template.domain.member.dao.MemberDAO;
import template.domain.member.view.MemberInsertViewImpl;

import java.util.Scanner;

public class MemberRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberDAO memberDAO = new MemberDAO();
        MemberInsertViewImpl insertView = new MemberInsertViewImpl();
        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====\n1. 회원정보 입력\n2. 회원정보 수정\n3. 회원 탈퇴\n4. 전체 회원 조회\n5. 프로그램 종료\n번호 입력 > ");
            int sel = sc.nextInt();
            if (sel == 5) {
                System.out.println("===== 프로그램 종료 =====");
                break;
            }
            if (memberDAO.insert(insertView.input()) == -1) break;
        }
    }
}
