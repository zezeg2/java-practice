package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;

import java.sql.SQLException;

public class GetMemberInfoViewImpl implements View {
    private static GetMemberInfoViewImpl instance;

    private GetMemberInfoViewImpl() {
    }

    public static GetMemberInfoViewImpl getInstance() {
        if (instance == null) instance = new GetMemberInfoViewImpl();
        return instance;
    }

    @Override
    public void run() throws SQLException {
        AuthorizeMemberDTO member = new AuthorizeMemberDTO();
        System.out.print("아이디 입력 > ");
        member.setId(sc.next());
        System.out.print("패스워드 입력 > ");
        member.setPw(sc.next());
        dao.getMemberInfo(member);
    }
}
