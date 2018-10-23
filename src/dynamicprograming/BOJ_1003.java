package dynamicprograming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1003 {
    static BufferedReader br;

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];
        dp[0][0] = 1 ;
        dp[1][1] = 1 ;

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            for(int i = 2; i <=n; i++){
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }
            System.out.println(dp[n][0]+" "+dp[n][1]);
        }
    }
}
