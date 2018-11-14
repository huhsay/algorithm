package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {

    public static void main(String args[]) throws IOException {
        ArrayList<Edge>[] graph;
        Queue<Integer> pq = new PriorityQueue<>();

        //init

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt((st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int[] dist = new int[V + 1];

        graph = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        int from, to, value;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, value));
        }

        //solve

        dist[start] = 0;
        pq.add(start);
        int currentVertex = 0;

        while(!pq.isEmpty()){
            currentVertex = pq.poll();

            for(int i = 0; i < graph[currentVertex].size(); i++){
                int nextVertex = graph[currentVertex].get(i).ver;
                int nextValue = graph[currentVertex].get(i).value;

                if(dist[nextVertex] > dist[currentVertex] + nextValue){
                    dist[nextVertex] = dist[currentVertex] + nextValue;
                    pq.add(nextVertex);
                }
            }
        }
        // print
        for(int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    static class Edge{
        int ver;
        int value;

        public Edge(int ver, int shortestValue) {
            this.ver = ver;
            this.value = shortestValue;
        }
    }

}
