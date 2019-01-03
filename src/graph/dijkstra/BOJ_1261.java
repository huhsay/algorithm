package graph.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final int MAX_RUPEE = 10000;
    static final int SRC = 0;

    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int N;
    static int M;
    static Queue<Point> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], MAX_RUPEE);
        }

        for (int i = 0; i < N; i++) {
            String nextLine = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = nextLine.charAt(j) - 48;
            }

        }

        dist[SRC][SRC] = map[SRC][SRC];

        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Point(SRC, SRC, map[SRC][SRC]));

        Point current;

        while (!priorityQueue.isEmpty()) {
            current = priorityQueue.poll();
            if (visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;

            if (current.x == N - 1 && current.y == M - 1) break;

            for (int i = 0; i < 4; i++) {

                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                if (visited[nextX][nextY]) continue;

                if (dist[nextX][nextY] > current.value + map[nextX][nextY]) {
                    dist[nextX][nextY] = current.value + map[nextX][nextY];
                }

                priorityQueue.add(new Point(nextX, nextY, dist[nextX][nextY]));
            }
        }

        System.out.print((dist[N - 1][M - 1]));
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }
}

