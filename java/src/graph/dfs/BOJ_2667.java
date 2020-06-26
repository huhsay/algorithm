package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BOJ_2667 {

    static char[][] map = new char[25][25];
    static boolean[][] visit = new boolean[25][25];

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Integer> pq = new PriorityQueue<>();

        // 모든 정점 방문하기

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '1' && !visit[y][x]) {
                    pq.add(dfs(new Point(x, y)));
                }
            }

        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

    }

    public static int dfs(Point point) {

        Stack<Point> stack = new Stack<>();
        stack.push(point);
        visit[point.y][point.x] = true;
        int cnt = 1;

        while (!stack.isEmpty()) {

            Point current = stack.peek();
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (checkMove(nextX, nextY)) {
                    flag = true;
                    stack.add(new Point(nextX, nextY));
                    cnt++;
                    visit[nextY][nextX] = true;
                    break;
                }

            }

            if (!flag) stack.pop();

        }

        return cnt;
    }

    public static boolean checkMove(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        if (map[y][x] == '0') return false;
        if (visit[y][x]) return false;
        return true;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
