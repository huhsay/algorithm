package graph.bipartite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 노트북의 주인을 찾아서
 * bipartite - 이분매칭
 */

public class BOJ_1298 {
    static int[] A = new int[101];
    static int[] B = new int[5001];
    static List<Integer>[] adj = new List[101];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        //bipartite

        int match = 0;
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            if (A[i] == 0) {
                Arrays.fill(visited, false);
                if (dfs(i)) match++;
            }
        }

        System.out.println(match);
    }

    private static boolean dfs(int a) {
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
