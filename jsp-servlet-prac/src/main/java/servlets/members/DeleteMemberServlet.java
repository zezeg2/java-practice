package servlets.members;


import domain.members.dtos.AuthorizeMemberDTO;
import domain.members.dtos.MemberDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/members/delete")
public class DeleteMemberServlet extends MembersServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        PrintWriter writer = resp.getWriter();
        try {
            AuthorizeMemberDTO member = new AuthorizeMemberDTO(req.getParameter("id"), req.getParameter("pw"));
            MemberDTO authMember = dao.getMember(member);
            dao.deleteMember(authMember.id());
            writer.println("유저정보가 삭제되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
