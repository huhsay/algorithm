package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10217 {

    /**
     *  dijkstra 응용 / kmc
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int INF = 10000000;

    public static void main(String args[]) throws IOException {
        int T = readInt();


        Queue<Edge> pq = new PriorityQueue<>();
        for(int t = 0; t < T; t++) {

            int N = readInt();  // 공항수
            int M = readInt();  // 총비용
            int K = readInt();  // 티켓(edgd)
            int[][] dp = new int[N+1][M+1];

            ArrayList<Edge>[] graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                Arrays.fill(dp[i], INF);
            }

            for (int i = 1; i <= K; i++) {
                int u = readInt();
                int v = readInt();
                int c = readInt();
                int d = readInt();

                graph[u].add(new Edge(v, c, d));
            }

            dp[1][0] = 0;

            pq.add(new Edge(1, 0, 0));


            while(!pq.isEmpty()){
                Edge currentEdge = pq.poll();

                if ( currentEdge.cost > M || currentEdge.time > dp[currentEdge.vertex][currentEdge.cost]) continue;

                for(int i = 0; i < graph[currentEdge.vertex].size(); i++){
                    Edge temp = graph[currentEdge.vertex].get(i);
                    int costSum = temp.cost + currentEdge.cost;
                    if( costSum > M) continue;
                    if((dp[temp.vertex][costSum] > dp[currentEdge.vertex][currentEdge.cost] + temp.time)){
                        dp[temp.vertex][costSum] = dp[currentEdge.vertex][currentEdge.cost] + temp.time;
                        pq.add(new Edge(temp.vertex, costSum,  dp[temp.vertex][costSum]));
                    }
                }
            }

            int min = INF;
            for(int i = 0; i <= M; i++){
                if(dp[N][i] != INF && min > dp[N][i]) min = dp[N][i];
            }

            if(min == INF){
                System.out.println("Poor KCM");
                continue;
            }

            System.out.println(min);
        }
    }

    static public int readInt() throws IOException{
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());
    }

    static class Edge implements Comparable<Edge>{
        int cost;
        int time;
        int vertex;

        public Edge(int vertex, int cost, int time) {
            this.cost = cost;
            this.time = time;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time > o.time ? 1 : -1;
        }
    }
}
