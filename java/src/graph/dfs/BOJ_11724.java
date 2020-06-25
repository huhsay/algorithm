package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    static boolean visit[] = new boolean[1001];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfsAll();
        System.out.println(ans);
    }

    public static void dfsAll() {
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }
    }

    public static void dfs(int vertex) {
        visit[vertex] = true;
        for (int i = 0; i < adj[vertex].size(); i++) {
            if (!visit[adj[vertex].get(i)]) dfs(adj[vertex].get(i));
        }
    }
}
