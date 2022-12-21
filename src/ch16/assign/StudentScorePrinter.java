package ch16.assign;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StudentScorePrinter {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        List<String> inputList = List.of("이름", "국어", "수학", "영어");
        Map<Integer, List<String>> infoMap = new LinkedHashMap<>();
        int count = 1;
        while (true) {
            List<String> info = new ArrayList<>(inputList.stream().map((e) -> {
                System.out.print(e + " : ");
                return sc.next();
            }).collect(Collectors.toList()));
            info.add(String.valueOf(info.subList(1, info.size()).stream().mapToInt(Integer::valueOf).sum()));
            info.add(String.valueOf(String.format("%.2f", info.subList(1, info.size() - 1).stream().mapToInt(Integer::valueOf).average().getAsDouble())));
            infoMap.put(count++, info);
            System.out.println("계속 등록 하시겠습니까? ('y' 계속, 종료하시려면 아무키나 누르세요)");
            String key = sc.next();
            if (!key.equalsIgnoreCase("y")) break;
        }
        FileWriter writer = new FileWriter("src/ch16/student-score.txt");
        writer.write(String.format("%s%s%s%s%s%s%s\n", "번호 ", "이름", "국어", "수학", "영어", "총점", "평균"));
        for (Map.Entry<Integer, List<String>> e : infoMap.entrySet()) {
            writer.write(e.getKey() + " " + e.getValue().stream().reduce("", ((s1, s2) -> s1 + " " + s2)) + "\n");
        }
        writer.close();
    }
}
