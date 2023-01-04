package servlets.members;


import domain.members.dtos.AuthorizeMemberDTO;
import domain.members.dtos.MemberDTO;
import domain.members.dtos.UpdateMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/members/update")
public class UpdateMemberServlet extends MembersServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            AuthorizeMemberDTO member = new AuthorizeMemberDTO(req.getParameter("id"), req.getParameter("pw"));
            MemberDTO origin = dao.getMember(member);

            String tempEmail = req.getParameter("email");
            if (dao.isExistEmail(tempEmail)) {
                writer.println("이미 존재하는 이메일 입니다.");
                return;
            }
            String email = tempEmail.equals("p") ? origin.email() : tempEmail;
            String pw = retainOrReplace(req.getParameter("pw"), "", origin.pw());
            String phone = retainOrReplace(req.getParameter("phone"), "", origin.phone());
            String address = retainOrReplace(req.getParameter("address"), "", origin.address());
            dao.updateMember(new UpdateMemberDTO(origin.id(), pw, email, phone, address));
            writer.println("유저정보 업데이트에 성공했습니다.");
        } catch (SQLException e) {

        }
    }
}
