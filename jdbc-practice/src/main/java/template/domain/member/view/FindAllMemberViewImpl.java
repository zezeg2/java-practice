package template.domain.member.view;

import java.sql.SQLException;

public class FindAllMemberViewImpl implements View {
    private static FindAllMemberViewImpl instance;

    private FindAllMemberViewImpl() {
    }

    public static FindAllMemberViewImpl getInstance() {
        if (instance == null) instance = new FindAllMemberViewImpl();
        return instance;
    }

    @Override
    public void run() throws SQLException {
        System.out.printf("페이지 번호 입력 (1 - %d 페이지) > ", dao.countPage());
        dao.findAllMember(sc.nextInt());
    }
}
