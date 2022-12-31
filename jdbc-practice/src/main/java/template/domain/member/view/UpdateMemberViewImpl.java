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
        AuthorizeMemberDTO member = new AuthorizeMemberDTO();
        System.out.print("아이디 입력 > ");
        member.setId(sc.next());
        System.out.print("패스워드 입력 > ");
        member.setPw(sc.next());
        MemberDTO origin = dao.getMember(member);

        System.out.println("재설정할 항목을 입력해주세요 (enter 'p'-> 다음항목)");
        System.out.print("새로운 이메일 입력 > ");
        String tempEmail = sc.next();
        if (dao.isExistEmail(tempEmail)) {
            System.out.println("이미 존재하는 이메일 입니다.");
            return;
        }
        String email = maintainOrGet(tempEmail, origin.getEmail());
        System.out.print("새로운 패스워드 입력 > ");
        String pw = maintainOrGet(sc.next(), origin.getPw());
        System.out.print("새로운 휴대전화 입력 > ");
        String phone = maintainOrGet(sc.next(), origin.getPhone());
        System.out.print("새로운 주소 입력 > ");
        String address = maintainOrGet(sc.next(), origin.getAddress());
        dao.updateMember(new UpdateMemberDTO(origin.getId(), pw, email, phone, address));
        System.out.println("유저정보 업데이트에 성공했습니다.");
    }

    private String maintainOrGet(String s1, String s2) {
        return s1.equals("p") ? s2 : s1;
    }
}
