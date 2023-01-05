package servlets.test.forward;

import domain.members.dtos.InfoMemberDTO;
import servlets.members.MembersServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/forward-c")
public class forwardTestServletC extends MembersServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String menu = req.getParameter("menu");
        if (menu.equals("member-list")) {
            try {
                List<InfoMemberDTO> list = dao.getAllMemberInfo(Integer.parseInt(req.getParameter("page")));
                req.setAttribute("list", list);
                req.getRequestDispatcher("/forward-d").forward(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
