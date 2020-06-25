package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lv2_2 {
    static int T;
    static int N;
    static int M;
    static int K;
    static int S;

    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            d = new int[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(d[i], 10000000);
            }

            Queue<Integer> target = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                target.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                d[from][to] = 1;
                d[to][from] = 1;

            }

            solve();

            int ans = 0;
            int start = S;
            int end = 0;
            while (!target.isEmpty()) {
                end = target.peek();
                ans += d[start][end];
                start = target.poll();
            }
            ans += d[start][S];

            System.out.println(String.format("#%d %d", t, ans));

        }
    }

    public static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

}
