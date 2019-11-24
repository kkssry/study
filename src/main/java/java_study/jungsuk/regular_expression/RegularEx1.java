package java_study.jungsuk.regular_expression;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car"
                , "combat", "count", "date", "disc"};
        Pattern p = Pattern.compile("c[a-z]*");     // c로 시작하는 소문자 영단어

        String[] arr = Arrays.stream(data).filter(i->i.startsWith("c")).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));       // c로 시작하는 모든 문자열 출력

        for (String datum : data) {
            Matcher m = p.matcher(datum);
            if (m.matches()) {
                System.out.print(datum + ",");      // c로 시작하는 소문자 영단어로 이루어지는 문자열 출력
            }
        }
    }
}
