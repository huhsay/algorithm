package graph;

import java.io.*;
import java.util.*;

/*
 Boj_6497
 use kruskal algo
 */
public class BOJ_6497 {
    public static int[] parent;
    public static Queue<Edge> edges = new PriorityQueue<>();

    public static int n;
    public static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            edges.clear();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if( n == 0 && m == 0) break;

            parent = new int[n];

            for(int i = 0 ; i < n; i++){
                parent[i] = i;
            }

            int total = 0;

            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                total += z;

                edges.add(new Edge(x, y, z));
            }

            int cnt = 0;
            int ans = 0;

            while(!edges.isEmpty() && cnt < n-1){
                Edge edge = edges.poll();
                int from = edge.x;
                int to = edge.y;

                if(union(from, to)){
                    cnt++;
                    ans += edge.z;
                }
            }
            bw.write(total - ans + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }


    public static int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y){

        int a = find(x);
        int b = find(y);

        if( a == b ) return false;

        parent[b] = a;
        return true;
    }


    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int z;

        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Edge o) {
            return this.z > o.z ? 1 : this.z == o.z ? 0 : -1 ;
        }
    }
}
