package template.domain.member;

import template.domain.member.dao.MemberDAO;
import template.domain.member.view.*;

import java.util.Scanner;

public class MemberRunner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            MemberDAO memberDAO = new MemberDAO();
            while (true) {
                System.out.print("===== 회원 관리 프로그램 =====\n1. 회원정보 입력\n2. 회원정보 수정\n3. 회원 탈퇴\n4. 회원 정보 조회\n5. 전체 회원 조회\n6. 프로그램 종료\n번호 입력 > ");
                int select = sc.nextInt();
                if (select == 6) {
                    System.out.println("===== 프로그램 종료 =====");
                    break;
                }
                int key = switch (select){
                    case 1 -> memberDAO.insert( CreateMemberViewImpl.getInstance().input(sc));
//                    case 2 -> memberDAO.updateMember(UpdateMemberViewImpl.getInstance().input(sc));
//                    case 3 -> memberDAO.deleteMember(DeleteMemberViewImpl.getInstance().input(sc));
                    case 4 -> memberDAO.getMyInfo(GetMemberInfoViewImpl.getInstance().input(sc));
                    case 5 -> memberDAO.findAllMember(FindAllMemberViewImpl.getInstance().input(sc));
                    default -> {
                        System.out.println("다시 입력해 주세요");
                        yield 1;
                    }
                };
                if (key == -1) break;
            }
        }
    }
}
