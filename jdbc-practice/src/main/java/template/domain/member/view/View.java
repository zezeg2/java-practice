package template.domain.member.view;

import template.domain.member.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Scanner;

public interface View {
    MemberDAO dao = MemberDAO.getInstance();
    Scanner sc = InputTaker.getInstance().getScanner();
    void run() throws SQLException;
}
