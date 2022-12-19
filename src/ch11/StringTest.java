package ch11;

import static ch11.StringComparator.*;

public class StringTest {
    public static void main(String[] args) {
        System.out.println(compare("javaprogram", "oracle", true));
        System.out.println(compare("javaprogram", "oracledatabase", false));
        splitUrl("http://www.kitri.re.kr:8080/java/test");
        String data = "지금 저는 ㅋㅋㅋ 수업중입니다. 정말요? 과제물도 ㅎㅎㅎ 하고 있구요.";
        deleteChar(data, new String[]{".", "ㅋ", "ㅎ","?", " "});
    }
}
