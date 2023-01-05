package servlets.test.session;

import servlets.members.MembersServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout-session")
public class LogoutSessionServlet extends MembersServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.getSession().removeAttribute("sessionId");
        writer.println("logout successfully");
    }
}
