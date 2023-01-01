package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.InfoMemberDTO;

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
        AuthorizeMemberDTO member = new AuthorizeMemberDTO(sc.nextString("아이디 입력 > "), sc.nextString("패스워드 입력 > "));
        InfoMemberDTO result = dao.getMemberInfo(member);
        System.out.println(result);
    }
}
