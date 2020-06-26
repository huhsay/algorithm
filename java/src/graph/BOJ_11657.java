package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
    static int N;
    static int M;
    static int[] dist;
    static int[][] map;
    static ArrayList<Edge>[] list;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String args[]) throws  IOException{

        // init
        N = readInt();
        M = readInt();

        dist = new int[N+1];
        map = new int[N+1][N+1];
        Arrays.fill(dist, 10000000);
        dist[1] = 0;

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M; i++){
            int ver1 = readInt();
            int ver2 = readInt();
            int cost = readInt();

            list[ver1].add(new Edge(ver2, cost));
        }

        // bellman-ford
        boolean negativeCycle = false;
        for(int i = 0; i < N ; i++){
            for(int j = 1; j <=N ; j++){
                for(int k = 0; k <list[j].size() ; k++){
                    int to = list[j].get(k).to;
                    int cost = list[j].get(k).cost;
                    if(dist[to] > dist[j] + cost){
                        if( i >= N-1){
                            negativeCycle = true;
                            break;
                        }
                        dist[to] = dist[j] + cost;


                    }
                }
            }
        }

        // print
        if(negativeCycle) {
            System.out.println(-1);
            return;
        }

        for(int i = 2; i <= N; i++){
            if(dist[i]==10000000){
                System.out.println(-1);
                continue;
            }
            System.out.println(dist[i]);
        }

    }

    public static int readInt() throws IOException{
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
