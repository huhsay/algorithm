import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1032 {

    static char[][] chars = new char[50][50];
    static char[] ans = new char[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < chars[0].length; i++) {
            char temp = chars[0][i];
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if(chars[j][i] != temp){
                    flag = true;
                    break;
                }
            }
            ans[i] = temp;
            if(flag) ans[i] = '?';

        }

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
           st.append(ans[i]);
        }
        System.out.print(st.toString().trim());
    }
}
