package servlets.test.forward;

import domain.members.dtos.InfoMemberDTO;
import servlets.members.MembersServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/forward-b")
public class forwardTestServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<h1> Parameter Value from OriginServlet : "+req.getParameter("value")+"</h1>");
        writer.println("<h1> Attribute Value that OriginServlet set : "+req.getAttribute("modified")+"</h1>");
    }
}
