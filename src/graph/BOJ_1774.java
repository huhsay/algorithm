package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1774 {

    static int[][] nodes;
    static PriorityQueue<Edge> edges = new PriorityQueue<>();
    static int root[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        nodes = new int[node+1][2];
        // 좌표구하기
        for(int i = 1; i <= node; i++){
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());

        }

        // 거리구하기
        for(int i = 1; i < node; i++){
            for(int j = i+1; j <= node; j++){
                double dis;

                dis = Math.sqrt(Math.pow(nodes[i][0]-nodes[j][0], 2)+Math.pow(nodes[i][1]-nodes[j][1], 2));
                edges.offer(new Edge(i,j,dis));
            }
        }

        root = new int[node+1];

        for(int i = 1; i <= node; i++){
            root[i]=i;
        }

        // 이미 연결된
        for(int i = 1; i <= edge; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        int cnt=0;
        double ans=0;

        while(cnt!=node-edge-1 && !edges.isEmpty()){
            Edge temp = edges.poll();

            if(union(temp.from, temp.to)){
                cnt++;
                ans += temp.value;
            }

        }

        System.out.println(String.format("%.2f", ans));

    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        double value;

        public Edge(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value > o.value ? 1 : this.value == o.value ? 0: -1 ;
        }
    }

    static int find(int x){
        if(root[x]==x) return x;

        return root[x] = find(root[x]);
    }

    static boolean union(int from, int to){
        int x = from;
        int y = to;

        int a = find(x);
        int b = find(y);

        if( a==b ) return false;

        root[b] = a;
        return true;
    }
}
