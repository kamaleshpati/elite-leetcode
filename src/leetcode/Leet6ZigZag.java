package leetcode;

public class Leet6ZigZag {
    public static String convert(String s, int numRows) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int start = i;
            while (start<s.length()){
                System.out.println(s.charAt(start));
                res.append(s.charAt(start));
                if(i<numRows/2)
                    start += 2*(numRows-i-1);
                else
                    start += 2*(i-1);
            }
            res.append("\n");
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
