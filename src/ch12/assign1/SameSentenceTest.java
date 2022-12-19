package ch12.assign1;

import java.util.ArrayList;
import java.util.Arrays;

public class SameSentenceTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("자바는 객체지향 언어입니다");
        list1.add("우리는 용산캠퍼스에서 자바를 배우는 중입니다");
        list1.add("오늘은 컬렉션 프레임워크를 배우죠! ");
        list1.add("내일은 스레드를 배울 예정입니다 ");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("자바는 객체지향 언어입니다");
        list2.add("우리는 청계천에서 자바를 배우는 중입니다");
        list2.add("오늘은 콜렉션 프레임워크를 배우죠! ");
        list2.add("내일은 스레드를 배울 예정입니다 ");
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("자바는 객체지향 언어입니다");
        list3.add("우리는 용산에서 자바를 배우는 중입니다");
        list3.add("오늘은 컬렉션 프레임워크를 배우죠! ");
        SameSentence ss = new SameSentence();

        System.out.println("list1, list2에서 같은 내용을 출력합니다");
        System.out.println(Arrays.toString(ss.compare(list1, list2)));
        System.out.println("================================");
        System.out.println("list1, list3에서 같은 내용을 출력합니다");
        System.out.println(Arrays.toString(ss.compare(list1, list3)));
    }
}
