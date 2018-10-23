package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1219 {

    public static void main(String args[]) throws IOException {
        final long INF = Long.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, value));
        }

        st = new StringTokenizer(br.readLine());
        int[] gain = new int[n];
        for(int i = 0; i < n; i++){
            gain[i] = Integer.parseInt(st.nextToken());
        }

        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[start] = gain[start];

        boolean f = false;
        FIRST:
        for (int i = 0; i < n+100; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge temp = graph[j].get(k);

                    if(dist[j]==INF) continue;
                    if(dist[j]==Long.MAX_VALUE) dist[temp.vertex] = Long.MAX_VALUE;
                    if(dist[temp.vertex] < dist[j] - temp.value + gain[temp.vertex]){

                        dist[temp.vertex] = dist[j] - temp.value + gain[temp.vertex];
                        if(i >= n){
                            dist[temp.vertex] = Long.MAX_VALUE;
                        }

                    }

                }
            }
        }

        if(dist[finish]==INF){
            System.out.println("gg");
            return;
        }

        if(dist[finish]==Long.MAX_VALUE){
            System.out.println("Gee");
            return;
        }

        System.out.print(dist[finish]);

    }

    static class Edge {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}
