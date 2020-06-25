package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[] dn = {0, 1, 0, -1};
    static int[] dm = {1, 0, -1, 0};
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        discovered = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs();

    }

    public static void bfs() {

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0, 1));

        int ans = 0;
        boolean istrue;
        while (!q.isEmpty()) {
            Point current = q.remove(); // visit current point

            if (current.n == N - 1 && current.m == M - 1) {
                istrue = true;
                ans = current.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = current.n + dn[i];
                int nextM = current.m + dm[i];

                if (checkMove(nextN, nextM)) {
                    q.add(new Point(nextN, nextM, current.dist + 1));
                    discovered[nextN][nextM] = true;
                }
            }
            ans++;
        }

        System.out.print(ans);

    }

    static boolean checkMove(int n, int m) {
        if (n < 0 || n >= N | m < 0 || m >= M) return false;
        if (discovered[n][m]) return false;
        if (map[n][m] == '0') return false;
        return true;
    }

    public static class Point {
        int n;
        int m;
        int dist;

        public Point(int x, int y, int dist) {
            this.n = x;
            this.m = y;
            this.dist = dist;
        }
    }

}
