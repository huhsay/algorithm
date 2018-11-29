package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_113399 {
    static int[] array;
    static int[] sum = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int ans = 0;
        for (int n = 1; n <= N; n++) {
            sum[n] = sum[n-1] + array[n-1];
            ans += sum[n];
        }

        System.out.println(ans);
    }
}
