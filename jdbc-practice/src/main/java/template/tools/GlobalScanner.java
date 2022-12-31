package template.tools;

import java.util.Scanner;

/**
 * Created by jonghyeon on 2022/12/30,
 * Package : template.domain.member.view
 */
public class GlobalScanner {
    private static GlobalScanner instance = null;

    private final Scanner scanner;

    private GlobalScanner() {
        this.scanner = new Scanner(System.in);
    }

    public static GlobalScanner getInstance() {
        if (instance == null) instance = new GlobalScanner();
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
