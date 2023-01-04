package servlets.members;


import domain.members.dtos.MemberDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/members/join")
public class CreateMemberServlet extends MembersServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String id = req.getParameter("id");
            if (dao.isExistId(id)) {
                writer.println("이미 존재하는 id 입니다.");
            }
            String email = req.getParameter("email");
            if (dao.isExistEmail(email)) {
                writer.println("이미 존재하는 이메일 입니다.");
            }
            String pw = req.getParameter("pw");
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            dao.createMember(new MemberDTO(id, pw, name, email, phone, address, null));
            writer.println("<h1>회원 등록 완료</h1>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
