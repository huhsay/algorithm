package graph.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11375 {
    public static final int MAX = 1001;
    static int[] A = new int[MAX];
    static int[] B = new int[MAX];
    static List<Integer>[] adj = new List[MAX];
    static int N, M;
    static boolean[] visited = new boolean[MAX];


    public static void main(String[] args) throws IOException {

        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int match = 0;

        for (int i = 1; i <= N; i++) {
            if (A[i] == 0) {
                Arrays.fill(visited, false);
                if (dfs(i)) match++;
            }
        }
        System.out.println(match);
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
