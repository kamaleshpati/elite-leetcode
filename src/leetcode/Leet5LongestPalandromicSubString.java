package leetcode;

public class Leet5LongestPalandromicSubString {

    public static String longestPalindrome(String s) {
        if (isPallendrom(s))
            return s;
        else {
            String left = longestPalindrome(s.substring(0,s.length()-1));
            String right = longestPalindrome(s.substring(1));
            return left.length()>=right.length()?left:right;
        }
    }

    private static boolean isPallendrom(String s) {
        if(s.length() == 1)
            return true;
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }

}
