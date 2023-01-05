package servlets.test.forward;

import domain.members.dtos.InfoMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/forward-d")
public class forwardTestServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<InfoMemberDTO> list = (List<InfoMemberDTO>) req.getAttribute("list");
        list.stream().map(e -> e.toString() + "<br>").forEach(writer::println);
    }
}
