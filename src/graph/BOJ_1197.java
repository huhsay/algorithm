package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197 {
    final static int MAX = 1000001;
    final static int MIN = -1000001;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int[][] map = new int[V+1][V+1];
        int[] dis = new int[V+1];
        int[] nearest = new int[V+1];

        for(int i= 1 ; i <= V ; i ++){
            Arrays.fill(map[i], MAX+1);
        }

        int from;
        int to;
        int value;

        // graph input
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            map[from][to] = value;
            map[to][from] = value;
        }

        //초기화

        for(int i = 1; i <= V; i++){
            dis[i] = map[1][i];
            nearest[i] = 1;
        }
        dis[1] = MIN;

        int ans=0;
        int cnt=0;
        int nearV=0;

        while(cnt < V-1){
            int min = MAX;

            for(int i = 1; i <= V; i++){
                if( MIN < dis[i] && dis[i] < min){
                    min = dis[i];
                    nearV = i;
                }
            }

            ans = ans + min;
            dis[nearV] = MIN;

            for(int i = 1; i <= V; i++){
                if(MIN < dis[i] && dis[i] > map[nearV][i]){
                    dis[i] = map[nearV][i];
                    nearest[i] = nearV;
                }
            }

            cnt++;
        }

        System.out.print(ans);
    }

}
