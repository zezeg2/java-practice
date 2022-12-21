package ch16;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    static int getData() throws IOException {
        String data = sc.next();
        try {
            return Integer.valueOf(data);
        } catch (Exception e) {
            throw new IOException(data);
        }
    }

    public static void main(String[] args) throws IOException {
        double data1, data2;
        List<String> menu = List.of("덧셈", "뺄셈", "곱셈", "나눗셈", "프로그램종료");
        List<BiFunction<Double, Double, Double>> opList = List.of((n1, n2) -> n1 + n2, (n1, n2) -> n1 - n2, (n1, n2) -> n1 * n2, (n1, n2) -> n1 / n2);
        String message = menu.stream().reduce("메뉴", (s1, s2) -> s1 + "\n" + (menu.indexOf(s2) + 1) + ". " + s2);
        System.out.println("계산기를 시작합니다. \n종료하려면 'q'를 입력하세요");
        while (true) {
            try {
                System.out.println(message);
                System.out.print("선택번호 입력 : ");
                int op = getData() - 1;
                if (op == 4) return;
                System.out.println(String.format("%s할 데이터1 입력", menu.get(op)));
                data1 = getData();
                System.out.println(String.format("%s할 데이터2 입력", menu.get(op)));
                data2 = getData();
                System.out.println(String.format("결과 : %.2f", opList.get(op).apply(data1, data2)));
            }catch (Exception e){
                if (e.getMessage().equals("q")) return;
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
