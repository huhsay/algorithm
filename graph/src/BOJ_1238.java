import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.PriorityQueue;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class BOJ_1238 {

    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static int[] dist;
    static boolean[] visit;
    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException {


        br =  new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[x][y]=v;
        }

        Arrays.fill(dist, 102);
        dist[X]=0;

        Queue<Integer> que = new PriorityQueue<>();
        int cnt = 0;
        int cur = X;

        while(cnt < N) {
            //거리 업데이트 하기
            for (int i = 1; i <= N; i++){
                if(visit[i]) continue;
                if(map[cur][i]==0) continue;
                if(dist[cur]+map[cur][i] < dist[i]) dist[i] = dist[cur]+map[cur][i];
            }
            visit[cur] = true;

            //가장짧은 노드 고르기
            int min =102;
            for(int i = 1; i <= N; i++){
                if(visit[i]) continue;
                if(dist[i]==0) continue;
                if( dist[i] < min) {
                    min = dist[i];
                    cur = i;
                }

            }
            cnt++;
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            if( dist[i] == 102) continue;
            max = Math.max(max, dist[i]);
        }

        int[] ans = Arrays.copyOf(dist, N+1);


        int max2 =0;
        for(int i = 1; i <= N; i++){

            if(i == X) continue;

            visit = new boolean[N+1];
            dist = new int[N+1];

            ans[i] = ans[i] + dist(i, X);
            max2 = Math.max(max2, ans[i]);
        }

        System.out.println(max2);

    }// main

    public static int dist(int s, int e){
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];

        Arrays.fill(dist, 102);
        dist[s]=0;

        Queue<Integer> que = new PriorityQueue<>();
        int cnt = 0;
        int cur = s;

        while(cnt < N) {
            //거리 업데이트 하기
            for (int i = 1; i <= N; i++){
                if(visit[i]) continue;
                if(map[cur][i]==0) continue;
                if(dist[cur]+map[cur][i] < dist[i]) dist[i] = dist[cur]+map[cur][i];
            }
            visit[cur] = true;

            //가장짧은 노드 고르기
            int min =102;
            for(int i = 1; i <= N; i++){
                if(visit[i]) continue;
                if(dist[i]==0) continue;
                if( dist[i] < min) {
                    min = dist[i];
                    cur = i;
                }

            }
            cnt++;

            if(visit[e]) break;
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            if( dist[i] == 102) continue;
            max = Math.max(max, dist[i]);
        }

        return dist[e];
    }

}
