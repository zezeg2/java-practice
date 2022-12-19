package ch11;

import java.util.Arrays;

public class StringComparator {
    public static int compare(String str1, String str2, boolean isLength) {
        return isLength ? Math.max(str1.length(), str2.length()) :
                str1.chars().filter(value -> value == 'a').count() > str2.chars().filter(value -> value == 'a').count() ? str1.length() : str2.length();
    }
    public static void splitUrl(String url){
        Arrays.stream(url.split("//")[1].split("[\\./:]"))
        .forEach(e -> System.out.println(e));
    }

    public static void deleteChar(String data, String[] omits){
        for (String o : omits) {
            data = data.replace(o, "");
        }
        System.out.println(data);
    }
}

