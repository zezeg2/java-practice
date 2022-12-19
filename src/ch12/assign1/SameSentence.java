package ch12.assign1;

import java.util.List;
import java.util.stream.IntStream;

public class SameSentence {
    String[] compare(List<String> list1, List<String> list2) {
        return IntStream.range(0, Math.min(list1.size(), list2.size()))
                .filter(i -> list1.get(i).equals(list2.get(i))).mapToObj(list1::get).toArray(String[]::new);
    }
}
