package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = N * N;
        int mid;
        int ans = 0;

        while (left <= right) {

            mid = (left + right) / 2;  // mid는 index가 아니라 값이다.

            int cnt = getCount(mid, N);

            if (cnt >= K) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);

    }

    static int getCount(int x, int N) {

        int count = 0;

        for (int i = 0; i <= N; i++) {
            count = Math.min(x / i, N);
        }

        return count;
    }
}
