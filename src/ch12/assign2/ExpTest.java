package ch12.assign2;

import java.util.Arrays;

public class ExpTest {
    static void judge(String expression) {
        if (expression.indexOf("(") > expression.indexOf(")") || expression.lastIndexOf("(") > expression.lastIndexOf(")")) return;
        if (expression.chars().filter(c -> c == '(' || c == ')').mapToObj(c -> String.valueOf((char) c))
                .reduce((s1, s2) -> s1.length() != 0 ? s1.charAt(s1.length() - 1) == s2.charAt(0) ? s1 + s2 : s1.substring(0, s1.length() - 1) : s1 + s2).get().length() == 0)
            System.out.println(String.format("%s : 괄호 일치 수식", expression));
    }
    public static void main(String[] args) {
        String expressions[] = {"(5-(2+3)*2)/4", "(2+3)*1)+3", "((2+3)*1)+3", "(5-(2+3)*2)/4)"};
        Arrays.stream(expressions).forEach(expression -> judge(expression));
    }
}
