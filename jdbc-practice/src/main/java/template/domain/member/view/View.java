package template.domain.member.view;

import template.domain.member.dao.MemberDAO;
import template.tools.GlobalScanner;

import java.sql.SQLException;

public interface View {
    MemberDAO dao = MemberDAO.getInstance();
    GlobalScanner sc = GlobalScanner.getInstance();
    void run() throws SQLException;
}
