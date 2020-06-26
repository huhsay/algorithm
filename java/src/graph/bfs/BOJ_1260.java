package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    static int N; // vertex
    static int M; // edge
    static int V; // start  vertex

    static int[][] map = new int[1001][1001];
    static boolean visit[] = new boolean[1001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map[n][m] = 1;
            map[m][n] = 1;
        }

        dfs(V);
        System.out.println(printdfs());

        Arrays.fill(visit, false);

        bfs(V);

    }

    public static void dfs(int v) {
        visit[v] = true;
        q.add(v);

        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if(!visit[i] && map[v][i] == 1){
                flag = true;
                dfs(i);
            }
        }

        if(!flag) return;
    }

    public static void dfsAll(int v){
        dfs(v);

        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                dfs(i);
            }
        }
    }

    public static String printdfs(){
        StringBuilder sb = new StringBuilder();

        while(q.size() != 0){
            int temp = q.remove();
            if(temp == 0) continue;

            sb.append(temp).append(" ");
        }
        return sb.toString().trim();
    }

    public static void bfs(int v) {

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(v);
        visit[v] = true;
        while(!q.isEmpty()){
            int current = q.remove();
            sb.append(current).append(" ");
            for (int i = 1; i <= N; i++) {
                if(map[current][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }

        System.out.print(sb.toString().trim());
    }
}
