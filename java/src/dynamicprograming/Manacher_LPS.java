package dynamicprograming;
public class Manacher_LPS {

    private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
    private String s;  // original string
    private char[] t;  // transformed string

    public Manacher_LPS(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 0; i < t.length; i++) {
            int mirror = 2 * center - i;
            // case 1: if selected index i less then right boundary
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // attempt to expand palindrome centered at i
            // also check the boundary conditions first
            while (i + p[i] < t.length && i - p[i] >= 0
                    && t[i + p[i]] == t[i - p[i]]) {
                p[i]++;
            }

            // case 3: if palindrome centered at i expands past right,
            // adjust center and right boundary based on new expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "#a#b#b#a#"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    private void preprocess() {
        t = new char[s.length() * 2 + 1];
        t[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = s.charAt(i);
            t[2 * i + 2] = '#';
        }
    }

    // longest palindromic substring
    public String longestPalindromicSubstring() {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 0; i < p.length; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2 + 1, (center - 1 + length) / 2);
    }

//    public String longestPalindromicSubstring(int i) {
//        int length = p[i];
//        int center = i;
//        return s.substring((center - 1 - length) / 2 + 1, (center - 1 + length) / 2);
//    }

    public static void main(String[] args) {
//        String s = "civicradarrevivermalayalammadamnoon";
//        String s = "babcbabcbaccba";
//        String s = "babcbabcbaccba";
//        String s = "abaaba";
//        String s = "abacdfgdcaba";
//          String s = "abacdfgdcabba";
        String s = "forgeeksskeegfor";
        Manacher_LPS manacher = new Manacher_LPS(s);
        System.out.println(manacher.longestPalindromicSubstring());
//        for (int i = 0; i < 2 * s.length(); i++) {
//            System.out.println(i + ": " + manacher.longestPalindromicSubstring(i));
//        }
    }
}