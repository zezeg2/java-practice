package template.domain.member.view;

import java.util.Scanner;

/**
 * Created by jonghyeon on 2022/12/30,
 * Package : template.domain.member.view
 */
public class InputTaker {
    private static InputTaker instance = null;

    private final Scanner scanner;

    private InputTaker() {
        this.scanner = new Scanner(System.in);
    }

    public static InputTaker getInstance() {
        if (instance == null) instance = new InputTaker();
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
