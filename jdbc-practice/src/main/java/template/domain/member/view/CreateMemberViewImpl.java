package template.domain.member.view;

import template.domain.member.dtos.MemberDTO;

import java.sql.SQLException;

public class CreateMemberViewImpl implements View {
    private static CreateMemberViewImpl instance;

    private CreateMemberViewImpl() {
    }

    public static CreateMemberViewImpl getInstance(){
        if (instance == null) instance = new CreateMemberViewImpl();
        return instance;
    }
    @Override
    public void run() throws SQLException {
        MemberDTO member = new MemberDTO();
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
        dao.createMember(member);
    }
}
