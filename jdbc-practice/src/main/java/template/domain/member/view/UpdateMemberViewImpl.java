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
        UpdateMemberDTO updateMemberDTO = new UpdateMemberDTO();
        updateMemberDTO.setId(origin.getId());
        System.out.println("재설정할 항목을 입력해주세요 (enter 'p'-> 다음항목)");
        System.out.print("새로운 패스워드 입력 > ");
        updateMemberDTO.setPw(maintainOrGet(sc.next(), origin.getPw()));
        System.out.print("새로운 이메일 입력 > ");
        updateMemberDTO.setEmail(maintainOrGet(sc.next(), origin.getEmail()));
        System.out.print("새로운 휴대전화 입력 > ");
        updateMemberDTO.setPhone(maintainOrGet(sc.next(), origin.getPhone()));
        System.out.print("새로운 주소 입력 > ");
        updateMemberDTO.setAddress(maintainOrGet(sc.next(), origin.getAddress()));
        dao.updateMember(updateMemberDTO);
    }

    private String maintainOrGet(String s1, String s2) {
        return s1.equals("p") ? s2 : s1;
    }
}
