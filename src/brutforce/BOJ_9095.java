package brutforce;

import java.util.Scanner;

public class BOJ_9095 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int t = 0; t < T; t++) {
            System.out.println(solve(sc.nextInt()));
        }
    }

    public static int solve(int i) {
        int ans = 0;

        if(i == 1) return 1;
        if(i == 2) return 2;
        if(i == 3) return 4;

        for (int j = 1; j <= 3; j++) {
            if (dp[i - j] != 0) {
                ans += dp[i - j];
                continue;
            }
            ans += solve(i - j);
        }
        dp[i] = ans;
        return ans;
    }
}
