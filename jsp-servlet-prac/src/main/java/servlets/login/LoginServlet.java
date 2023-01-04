package servlets.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/loginProcess")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String role = req.getParameter("role").equals("admin") ? "관리자" : "회원";
        req.getParameterMap().forEach((key, value) -> System.out.println(key + " : " + Arrays.toString(value)));

        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h1>%s %s님 로그인환영 ㅎ</h1>",id,role));
        writer.println(String.format("<h1>님 패스워드 %s ㅎ</h1>",password));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
