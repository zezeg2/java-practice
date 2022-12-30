package template.domain.member.view;

import template.domain.member.dtos.CreateMemberDTO;

import java.util.Scanner;

public class CreateMemberViewImpl implements View<CreateMemberDTO> {
    private static CreateMemberViewImpl instance;

    private CreateMemberViewImpl() {
    }

    public static CreateMemberViewImpl getInstance(){
        if (instance == null) return new CreateMemberViewImpl();
        return instance;
    }

    @Override
    public CreateMemberDTO input(Scanner sc) {
        CreateMemberDTO member = new CreateMemberDTO();
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
        return member;
    }
}
