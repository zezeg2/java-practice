package template.domain.member.view;

import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.MemberDTO;
import template.domain.member.dtos.UpdateMemberDTO;

import java.sql.SQLException;

public class UpdateMemberViewImpl implements View {
    private static UpdateMemberViewImpl instance;

    private UpdateMemberViewImpl() {
    }

    public static UpdateMemberViewImpl getInstance() {
        if (instance == null) instance = new UpdateMemberViewImpl();
        return instance;
    }

    public void run() throws SQLException {
        AuthorizeMemberDTO member = new AuthorizeMemberDTO(sc.nextString("아이디 입력 > "), sc.nextString("패스워드 입력 > "));
        MemberDTO origin = dao.getMember(member);

        System.out.println("재설정할 항목을 입력해주세요 (enter 'p'-> 다음항목)");
        String tempEmail = sc.nextString("새로운 이메일 입력 > ");
        if (dao.isExistEmail(tempEmail)) {
            System.out.println("이미 존재하는 이메일 입니다.");
            return;
        }
        String email = tempEmail.equals("p") ? origin.getEmail() : tempEmail;
        String pw = sc.nextStringOrReplace("새로운 패스워드 입력 > ", "p", origin.getPw());
        String phone = sc.nextStringOrReplace("새로운 휴대전화 입력 > ", "p", origin.getPhone());
        String address = sc.nextStringOrReplace("새로운 주소 입력 > ", "p", origin.getAddress());
        dao.updateMember(new UpdateMemberDTO(origin.getId(), pw, email, phone, address));
        System.out.println("유저정보 업데이트에 성공했습니다.");
    }
}
