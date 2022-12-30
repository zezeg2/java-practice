package template.domain.member.view;

import java.util.Scanner;

public class FindAllMemberViewImpl implements View<Integer> {
    private static FindAllMemberViewImpl instance;

    private FindAllMemberViewImpl() {
    }

    public static FindAllMemberViewImpl getInstance(){
        if (instance == null) return new FindAllMemberViewImpl();
        return instance;
    }
    @Override
    public Integer input(Scanner sc) {
        System.out.print("페이지 번호 입력 > ");;
        return sc.nextInt();
    }
}
