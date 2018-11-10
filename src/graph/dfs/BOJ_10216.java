package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10216 {
    static int T;
    static Point[] points = new Point[3000];

    static boolean[] visited = new boolean[3000];
    static boolean[][] map = new boolean[3000][3000];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N  = Integer.parseInt(br.readLine());
 //           boolean[] visited = new boolean[N];
  //          boolean[][] map = new boolean[N][N];

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                points[n] = new Point(n, x, y, r);
            } // input

            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if(isConnected(points[i],points[j])){
                        map[i][j] = map[j][i] = true;
                    }
                }
            } // 그래프 만들기

            int count = 0;
            for (int i = 0; i <N; i++) {
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            } // 연결 확인


            System.out.println(count);

            Arrays.fill(visited, false);
            Arrays.fill(points, null);
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], false);
            }

        } // testcase


    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < N; j++) {
            if(map[i][j]){
                if(!visited[j]){
                    dfs(j);
                }
            }
        }
    }

    private static boolean isConnected(Point from, Point to) {

        double leng = Math.sqrt((from.x-to.x)*(from.x-to.x)+(from.y-to.y)*(from.y-to.y));
        int rleng = from.r + to.r;

        return leng > rleng ? false : true;
    }

    static class Point{
        int i;
        int x;
        int y;
        int r;

        public Point(int i, int x, int y, int r) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
