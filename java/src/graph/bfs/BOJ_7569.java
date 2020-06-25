package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int M;
    static int N;
    static int H;
    static int[][][] map;

    static int[] dm = {0, 1, 0, -1, 0, 0};
    static int[] dn = {1, 0, -1, -0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];

        Queue<Point> q = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j][h] = temp;
                    if (temp == 1) {
                        q.add(new Point(i, j, h));
                    }
                }
            } // input
        }

        int time = -1;

        while (!q.isEmpty()) {
            time++;
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Point current = q.remove();

                for (int j = 0; j < 6; j++) {
                    int nextM = current.m + dm[j];
                    int nextN = current.n + dn[j];
                    int nextH = current.h + dh[j];
                    if (canNext(nextN, nextM, nextH)) {
                        q.add(new Point(nextN, nextM, nextH));
                        map[nextN][nextM][nextH] = 1;
                    }
                }
            }
        }

        if (!isFull()) {
            System.out.println(-1);
            return;
        }
        System.out.println(time);
    }

    public static boolean canNext(int n, int m, int h) {
        if (m < 0 || m >= M || n < 0 || n >= N || h < 0 || h >= H) return false;
        if (map[n][m][h] == -1 || map[n][m][h] == 1) return false;
        return true;
    }

    public static boolean isFull() {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                for (int h = 0; h < H; h++) {
                    if (map[n][m][h] == 0) return false;
                }
            }
        }
        return true;
    }


    public static class Point {
        int m;
        int n;
        int h;

        public Point(int x, int y, int h) {
            this.n = x;
            this.m = y;
            this.h = h;
        }
    }
}
