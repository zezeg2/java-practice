package servlets.members;

import domain.members.dao.MemberDAO;

import javax.servlet.http.HttpServlet;

public abstract class MembersServlet extends HttpServlet {
    protected MemberDAO dao;

    {
        try {
            dao = MemberDAO.getInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected String retainOrReplace(String input, String check, String replace){
        return input.equals(check) ? replace : input;
    }

}
