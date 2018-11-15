package dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    static int N;
    static int[] array = new int[1002];
    static int[] dp = new int[1002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(st.nextToken());
        }

        dp[N-1] = array[N-1];

        int ans = 0;
        for (int i = N-1; i >= 0 ; i--) {
            int temp = array[i];
            for (int j = i+1; j < N; j++) {
                if(array[i] < array[j]){
                    temp = max(temp, array[i]+dp[j]);
                }
            }
            dp[i] = temp;
            ans = max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    private static int max(int a, int b){
        return a > b ? a : b ;
    }
}
