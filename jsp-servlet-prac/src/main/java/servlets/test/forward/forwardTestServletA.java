package servlets.test.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forward-a")
public class forwardTestServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String value = req.getParameter("value");

        String modified = value.toUpperCase();
        req.setAttribute("modified", modified);
        req.getRequestDispatcher("/forward-b").forward(req, resp);
    }
}
