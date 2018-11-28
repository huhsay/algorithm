package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if(isAnagram(a, b)){
                System.out.println(String.format("%s & %s are anagrams.",a,b));
            }else{
                System.out.println(String.format("%s & %s are NOT anagrams.",a,b));
            }

        }
    }

    private static boolean isAnagram(String a, String b) {
        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        String stringa = new String(c);
        String stringb = new String(d);

        return stringa.equals(stringb);
    }
}
