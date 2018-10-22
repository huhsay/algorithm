import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] ans = new int[26];

        for (int i = 0; i <chars.length ; i++) {
            int a = chars[i] - 'a';
            ans[a]++;
        }

        for (int i = 0; i <26 ; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
