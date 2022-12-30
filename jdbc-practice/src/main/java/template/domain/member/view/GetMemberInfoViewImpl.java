package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;

import java.util.Scanner;

public class GetMemberInfoViewImpl<T> implements View<AuthorizeMemberDTO> {
    private static GetMemberInfoViewImpl instance;

    private GetMemberInfoViewImpl() {
    }

    public static GetMemberInfoViewImpl getInstance(){
        if (instance == null) return new GetMemberInfoViewImpl();
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
