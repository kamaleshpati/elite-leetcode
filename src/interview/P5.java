package interview;

import java.util.Arrays;
import java.util.List;

public class P5 {

    public static long countMax(List<String> upRight) {
        String[] s = upRight.get(0).split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        for (int i = 0; i < upRight.size(); i++) {
            String[] temp = upRight.get(i).split(" ");
            if(a>Integer.parseInt(temp[0]))
                a = Integer.parseInt(temp[0]);
            if(b>Integer.parseInt(temp[1]))
                b = Integer.parseInt(temp[1]);
        }

        return a*b;
    }

    public static void main(String[] args) {
        System.out.println(countMax(Arrays.asList("1 4","2 3", "4 1")));
    }
}
