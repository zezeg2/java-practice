package template.domain.member.view;

import template.domain.member.dao.MemberDAO;
import template.domain.member.dtos.AuthorizeMemberDTO;
import template.domain.member.dtos.InfoMemberDTO;
import template.domain.member.dtos.UpdateMemberDTO;

import java.util.Scanner;

public class UpdateMemberViewImpl implements View<UpdateMemberDTO> {
    private static UpdateMemberViewImpl instance;

    private UpdateMemberViewImpl() {
    }

    public static UpdateMemberViewImpl getInstance(){
        if (instance == null) return new UpdateMemberViewImpl();
        return instance;
    }
    public UpdateMemberDTO input(Scanner sc) {
        AuthorizeMemberDTO authMember = GetMemberInfoViewImpl.getInstance().input(sc);
        MemberDAO memberDAO = new MemberDAO();
        InfoMemberDTO prevMember = memberDAO.getMember(authMember);
        if (prevMember == null) return null;
        UpdateMemberDTO updateInfo = new UpdateMemberDTO();
        System.out.print("스킵하려면 Press Enter > ");
        System.out.print("새로운 패스워드 입력 > ");
        updateInfo.setPw(sc.next());
        System.out.print("새로운 이메일 입력 > ");
        updateInfo.setEmail(sc.next());
        System.out.print("새로운 휴대전화 입력 > ");
        updateInfo.setPhone(sc.next());
        System.out.print("새로운 주소 입력 > ");
        updateInfo.setAddress(sc.next());
        if (!updateInfo.getPw().equals("")) prevMember.setPw(updateInfo.getPw());
        if (!updateInfo.getEmail().equals(""))prevMember.setEmail(updateInfo.getEmail());
        if (!updateInfo.getPhone().equals(""))prevMember.setPhone(updateInfo.getPhone());
        if (!updateInfo.getAddress().equals(""))prevMember.setAddress(updateInfo.getAddress());
        return updateInfo;
    }
}
