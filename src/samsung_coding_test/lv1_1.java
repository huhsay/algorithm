package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lv1_1 {
    static int T;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(st.nextToken());
            for (int n = 0; n < N-1; n++) {
                char temp = st.nextToken().charAt(0);
                if(sb.charAt(0) <= temp){
                    sb.insert(0, temp);
                }else{
                    sb.append(temp);
                }
            }

            System.out.println(String.format("#%d %s", t,sb.toString()));

        }
    }
}
