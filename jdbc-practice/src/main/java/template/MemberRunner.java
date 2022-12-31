package template;

import template.domain.member.view.*;
import template.tools.GlobalScanner;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberRunner {
    public static void main(String[] args) {
        try (Scanner sc = GlobalScanner.getInstance().getScanner()) {
            System.out.println("===== 회원 관리 프로그램 =====");
            while (true) {
                System.out.print("\n1. 회원정보 입력\n2. 회원정보 수정\n3. 회원 탈퇴\n4. 회원 정보 조회\n5. 전체 회원 조회\n6. 프로그램 종료\n번호 입력 > ");
                int select = sc.nextInt();
                if (select == 6) {
                    System.out.println("====== 프로그램 종료 ======");
                    break;
                }
                try {
                    switch (select) {
                        case 1 -> CreateMemberViewImpl.getInstance().run();
                        case 2 -> UpdateMemberViewImpl.getInstance().run();
                        case 3 -> DeleteMemberViewImpl.getInstance().run();
                        case 4 -> GetMemberInfoViewImpl.getInstance().run();
                        case 5 -> GetAllMemberInfoViewImpl.getInstance().run();
                        default -> System.out.println("다시 입력해 주세요");
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}
