package servlets.members;


import domain.members.dtos.InfoMemberDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/members/all")
public class GetAllMemberInfoServlet extends MembersServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<InfoMemberDTO> result = dao.getAllMemberInfo(Integer.parseInt(req.getParameter("page")));
            result.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
