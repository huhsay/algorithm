package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lv2_1 {
    static int T;
    static int N; // 우주선 개수
    static int M; // 미사일 종류의 수
    static int B; // 방어막 세기

    static int[] missiles = new int[20001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {

            int ans = 0;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            missiles[0] = 200000;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int missile = Integer.parseInt(st.nextToken());
                int numberOfMissile = Integer.parseInt(st.nextToken());

                missiles[missile] = numberOfMissile;
            }

            boolean flag = false;
            SOLVE:
            for (int i = B; i <= 20000; i++) {

                for (int j = 0; j <= i / 2; j++) {
                    while (missiles[j] > 0 && missiles[i - j] > 0) {

                        if (j == i - j) {
                            if (missiles[j] < 2) break;
                        }
                        missiles[j]--;
                        missiles[i - j]--;
                        N--;
                        ans += i;

                        if (N == 0) {
                            flag = true;
                            break SOLVE;
                        }
                    }
                }
            }


            if (!flag) {
                ans = -1;
            }
            System.out.println(String.format("#%d %d", t, ans));

            Arrays.fill(missiles, 0);
        }
    }

}
