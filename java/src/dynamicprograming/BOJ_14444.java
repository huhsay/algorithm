package dynamicprograming;

import java.util.Scanner;

public class BOJ_14444 {

    private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
    private String s;  // original string
    private char[] t;  // transformed string

    public BOJ_14444(String s) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        BOJ_14444 manacher = new BOJ_14444(s);
        System.out.println(manacher.longestPalindromicSubstring().length());
    }
}
