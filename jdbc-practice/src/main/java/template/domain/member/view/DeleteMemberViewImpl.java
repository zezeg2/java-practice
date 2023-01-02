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
        AuthorizeMemberDTO member = new AuthorizeMemberDTO(sc.nextString("아이디 입력 > "), sc.nextString("패스워드 입력 > "));
        MemberDTO authMember = dao.getMember(member);
        dao.deleteMember(authMember.id());
        System.out.println("유저정보가 삭제되었습니다.");
    }
}
