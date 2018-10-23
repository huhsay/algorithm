package etc;

import java.util.ArrayList;

public class KMP {

    public static int[] getPi(String pattern){
        int m = pattern.length();
        int j = 0;
        char[] p;
        int[] pi = new int[m];

        p = pattern.toCharArray();

        for(int i = 1; i < m ; i++){
            while(j > 0 && p[i] != p[j]){
                j = pi[j -1];
            }
            if(p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    public static ArrayList<Integer> kmp(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int n = str.length(), m = pattern.length(), j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for(int i = 0; i < n; i++){
            while(j > 0 && s[i] != p[j]){
                j = pi[j -1];
            }

            if (s[i] == p[j]) {
                if (j == m - 1) {
                    list.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}
