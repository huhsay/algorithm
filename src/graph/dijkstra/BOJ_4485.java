package graph.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static final int MAX_RUPEE = 1250;
    static final int SRC = 0;

    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int N;
    static int problemCount = 0;
    static Queue<Point> priorityQueue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        while (N != 0) {
            problemCount++;

            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], MAX_RUPEE);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j <N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
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

                if (current.x == N - 1 && current.y == N - 1) break;

                for (int i = 0; i < 4; i++) {

                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

                    if (visited[nextX][nextY]) continue;

                    if (dist[nextX][nextY] > current.rupee + map[nextX][nextY]) {
                        dist[nextX][nextY] = current.rupee + map[nextX][nextY];
                    }

                    priorityQueue.add( new Point(nextX, nextY, dist[nextX][nextY]));
                }
            }

            bw.write(String.format("Problem %d: %d\n", problemCount, dist[N - 1][N - 1]));
            bw.flush();
            N = Integer.parseInt(br.readLine());

        }
        bw.close();
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int rupee;

        public Point(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        @Override
        public int compareTo(Point o) {
            return this.rupee - o.rupee;
        }
    }
}

