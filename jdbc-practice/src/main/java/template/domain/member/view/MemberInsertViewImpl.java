package template.domain.member.view;

import template.domain.member.dtos.MemberDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MemberInsertViewImpl implements View {
    MemberDTO member;
    @Override
    public MemberDTO input() {
        Scanner sc = new Scanner(System.in);
        member = new MemberDTO();
        System.out.print("아이디 입력 > ");
        member.setId(sc.next());
        System.out.print("패스워드 입력 > ");
        member.setPw(sc.next());
        System.out.print("이름 입력 > ");
        member.setName(sc.next());
        System.out.print("이메일 입력 > ");
        member.setEmail(sc.next());
        System.out.print("휴대전화 입력 > ");
        member.setPhone(sc.next());
        System.out.print("주소 입력 > ");
        member.setAddress(sc.next());
        member.setIndate(Date.valueOf(LocalDate.now()).toString());
        return member;
    }
}
