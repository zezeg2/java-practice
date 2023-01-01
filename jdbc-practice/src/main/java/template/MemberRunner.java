package template;

import template.domain.member.view.*;
import template.tools.GlobalScanner;

import java.sql.SQLException;

public class MemberRunner {
    public static void main(String[] args) {
        try (GlobalScanner sc = GlobalScanner.getInstance()) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("\n1. 회원정보 입력\n2. 회원정보 수정\n3. 회원 탈퇴\n4. 회원 정보 조회\n5. 전체 회원 조회\n6. 메뉴보기\n'q' => 프로그램 종료");
            while (true) {
                int select = sc.nextNumOrCheckReplace("\n메뉴 입력 > ", "q", 0);
                if (select == 0) {
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
                        case 6 -> System.out.print("\n1. 회원정보 입력\n2. 회원정보 수정\n3. 회원 탈퇴\n4. 회원 정보 조회\n5. 전체 회원 조회\n6. 메뉴보기\n'q' => 프로그램 종료");
                        default -> System.err.print("올바른 값을 입력해주세요. 재 선택 > ");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    break;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
