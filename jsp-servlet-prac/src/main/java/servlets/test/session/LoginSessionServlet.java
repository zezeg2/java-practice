package servlets.test.session;

import servlets.members.MembersServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-session")
public class LoginSessionServlet extends MembersServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");

        if (req.getSession().getAttribute("sessionId") == null){
            if (id == null) {
                writer.println("you need to login");
                return;
            }
            writer.println("you login now");
            req.getSession().setAttribute("sessionId", id);
            req.getSession().setMaxInactiveInterval(60 * 10);
        } else writer.println("you have session");
        writer.println("<h2></h2>");
        writer.println("<h2><a href=\"info-session\">My Info</a></h2>");
        writer.println("<h2><a href=\"logout-session\">Logout</a></h2>");
        writer.println("<h2>" + req.getSession().getMaxInactiveInterval() + "</h2>");
    }
}
