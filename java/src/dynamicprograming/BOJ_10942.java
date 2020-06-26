package dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    static int N;
    static int M;
    static int[][] dp = new int[2001][2001];
    static int[]  n = new int[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= N-1; i++) {
            if(n[i]==n[i+1]){
                dp[i][i+1] = 1;
            }
        }

        for (int k = 3; k <= N; k++) {
            for (int i = 1; i <= N-k+1 ; i++) {
                int j = i+k-1;
                if( dp[i+1][j-1] == 1 && n[i] == n[j] )
                    dp[i][j] = 1;
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(dp[start][end]);
        }

    }
}
