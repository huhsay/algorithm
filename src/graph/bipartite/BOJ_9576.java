package graph.bipartite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  백준 책나눠주기
 *  bipartite - 이분매칭
 */

public class BOJ_9576 {
    public static final int MAX = 1000;
    static int T;
    static int N;
    static int M;

    static int[] A;
    static int[] B;
    static List<Integer>[] adj;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 책
            M = Integer.parseInt(st.nextToken()); // 학생

            A = new int[M+1];
            B = new int[N+1];
            visited = new boolean[M+1];

            adj = new List[M+1];
            for (int i = 1; i <= M; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                for (int j = from; j <= to; j++) {
                    adj[i].add(j);
                }

            }

            int match = 0;

            for (int i = 1; i <= M; i++) {
                if (A[i] == 0) {
                    Arrays.fill(visited, false);
                    if (dfs(i)) match++;
                }
            }

            System.out.println(match);

        }
    }

    public static boolean dfs(int a) {
        visited[a] = true;
        for (int b : adj[a]) {
            if (B[b] == 0 || !visited[B[b]] && dfs(B[b])) {
                B[b] = a;
                A[a] = b;
                return true;
            }
        }
        return false;
    }
}
