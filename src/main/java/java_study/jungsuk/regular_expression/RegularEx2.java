package java_study.jungsuk.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "c", "cA", "ca", "co",
                         "c.", "c0", "c#", "car", "combat", "count", "date", "disc"};

        String[] pattern = {".*", "c[a-z]*", "c[a-z]", "c[a-zA-Z]", "c[a-zA-Z0-9]",
                            "c.", "c.*", "c\\.", "c\\w", "c\\d", "c.*t", "[b|c].*", ".*a.*" , ".*a.+",
                            "[b|c].{2}"};

        for (String s : pattern) {
            Pattern p = Pattern.compile(s);
            System.out.print("Pattern : " + s + "  결과 : ");
            for (String datum : data) {
                Matcher m = p.matcher(datum);
                if (m.matches()) {
                    System.out.print(datum + ", ");
                }
            }
            System.out.println();
        }
    }
}


