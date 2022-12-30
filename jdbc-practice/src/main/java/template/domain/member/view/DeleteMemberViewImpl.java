package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.MemberDTO;

import java.sql.SQLException;

public class DeleteMemberViewImpl implements View {
    private static DeleteMemberViewImpl instance;

    private DeleteMemberViewImpl() {
    }

    public static DeleteMemberViewImpl getInstance() {
        if (instance == null) instance = new DeleteMemberViewImpl();
        return instance;
    }

    @Override
    public void run() throws SQLException {
        AuthorizeMemberDTO member = new AuthorizeMemberDTO();
        System.out.print("아이디 입력 > ");
        member.setId(sc.next());
        System.out.print("패스워드 입력 > ");
        member.setPw(sc.next());
        MemberDTO authMember = dao.getMember(member);
        dao.deleteMember(authMember.getId());
    }
}
