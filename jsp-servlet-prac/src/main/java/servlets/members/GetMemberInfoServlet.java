package servlets.members;


import domain.members.dtos.AuthorizeMemberDTO;
import domain.members.dtos.InfoMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/members/info")
public class GetMemberInfoServlet extends MembersServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            AuthorizeMemberDTO member = new AuthorizeMemberDTO(req.getParameter("id"), req.getParameter("pw"));
            InfoMemberDTO result = dao.getMemberInfo(member);
            writer.println(String.format("<h1>%s %s 로그인 하셨습니다<h1>",result.id(), req.getParameter("role")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
