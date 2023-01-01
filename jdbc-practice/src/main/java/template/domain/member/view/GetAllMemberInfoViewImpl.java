package template.domain.member.view;

import template.domain.member.dtos.InfoMemberDTO;

import java.sql.SQLException;
import java.util.List;

public class GetAllMemberInfoViewImpl implements View {
    private static GetAllMemberInfoViewImpl instance;

    private GetAllMemberInfoViewImpl() {
    }

    public static GetAllMemberInfoViewImpl getInstance() {
        if (instance == null) instance = new GetAllMemberInfoViewImpl();
        return instance;
    }

    @Override
    public void run() throws SQLException {
        List<InfoMemberDTO> result = dao.getAllMemberInfo(sc.nextNum(String.format("페이지 번호 입력 (1 - %d 페이지) > ", dao.countPage())));
        result.forEach(System.out::println);
    }
}
