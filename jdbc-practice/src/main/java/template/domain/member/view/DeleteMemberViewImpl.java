package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;

import java.util.Scanner;

public class DeleteMemberViewImpl implements View<AuthorizeMemberDTO> {
    private static DeleteMemberViewImpl instance;

    private DeleteMemberViewImpl() {
    }

    public static DeleteMemberViewImpl getInstance(){
        if (instance == null) return new DeleteMemberViewImpl();
        return instance;
    }
    @Override
    public AuthorizeMemberDTO input(Scanner sc) {
        AuthorizeMemberDTO member = new AuthorizeMemberDTO();
        System.out.print("아이디 입력 > ");
        member.setId(sc.next());
        System.out.print("패스워드 입력 > ");
        member.setPw(sc.next());
        return member;
    }
}
