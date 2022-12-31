package template.domain.member.view;

import template.domain.member.dtos.MemberDTO;

import java.sql.SQLException;

public class CreateMemberViewImpl implements View {
    private static CreateMemberViewImpl instance;

    private CreateMemberViewImpl() {
    }

    public static CreateMemberViewImpl getInstance() {
        if (instance == null) instance = new CreateMemberViewImpl();
        return instance;
    }

    @Override
    public void run() throws SQLException {
        System.out.print("아이디 입력 > ");
        String id = sc.next();
        if (dao.isExistId(id)) {
            System.out.println("이미 존재하는 id 입니다.");
            return;
        }
        System.out.print("이메일 입력 > ");
        String email = sc.next();
        if (dao.isExistEmail(email)) {
            System.out.println("이미 존재하는 이메일 입니다.");
            return;
        }
        System.out.print("패스워드 입력 > ");
        String pw = sc.next();
        System.out.print("이름 입력 > ");
        String name = sc.next();
        System.out.print("휴대전화 입력 > ");
        String phone = sc.next();
        System.out.print("주소 입력 > ");
        String address = sc.next();
        dao.createMember(new MemberDTO(id, pw, name, email, phone, address));
        System.out.println("회원 등록 완료");
    }
}
