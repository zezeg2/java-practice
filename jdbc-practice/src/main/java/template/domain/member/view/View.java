package template.domain.member.view;

import template.domain.member.dao.MemberDAO;
import template.tools.GlobalScanner;

import java.sql.SQLException;
import java.util.Scanner;

public interface View {
    MemberDAO dao = MemberDAO.getInstance();
    Scanner sc = GlobalScanner.getInstance().getScanner();
    void run() throws SQLException;
}
