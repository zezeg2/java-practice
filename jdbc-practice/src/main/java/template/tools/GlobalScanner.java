package template.tools;

import java.io.Closeable;
import java.util.Scanner;

/**
 * Created by jonghyeon on 2022/12/30,
 * Package : template.domain.member.view
 */
public class GlobalScanner implements Closeable {
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

    public int nextNum(String comment) {
        System.out.print(comment);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("올바른 값을 입력해주세요. 재 선택 > ");
        }
        return scanner.nextInt();
    }

    public String nextString(String comment) {
        System.out.print(comment);
        return scanner.next();
    }

    public int nextNumOrCheckReplace(String comment, String check, int replace) {
        System.out.print(comment);
        while (!scanner.hasNextInt()) {
            if (scanner.next().equalsIgnoreCase(check)) return replace;
            System.err.printf("올바른 숫자를 입력해주세요 (종료 : '%s') 메뉴 입력 > ", check);
        }
        return scanner.nextInt();
    }

    public String nextStringOrReplace(String comment, String check, String replace){
        System.out.print(comment);
        String input = scanner.next();
        return input.equals(check) ? replace : input;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
