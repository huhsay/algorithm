package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

    private static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int I = 0;

        int x, y;
        for (int i = 0; i < N; i++) {
             I = Integer.parseInt(br.readLine());
             st = new StringTokenizer(br.readLine());
             y = Integer.parseInt(st.nextToken());
             x = Integer.parseInt(st.nextToken());
             Point start = new Point(x, y);

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            Point end = new Point(x, y);

            System.out.println(solve(I, start, end));
        }
    }

    private static int solve(int i, Point start, Point end) {

        int[][] map = new int[i][i];
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            if(isSame(q.peek(), end)) return map[end.y][end.x];

            Point current = q.poll();
            int nextX, nextY;
            for (int j = 0; j < 8; j++) {
                nextX = current.x + dx[j];
                nextY = current.y + dy[j];

                if(!isMoved(nextX, nextY, i)) continue;
                if(map[nextY][nextX] != 0) continue;

                map[nextY][nextX] = map[current.y][current.x] + 1;
                q.add(new Point(nextX, nextY));
            }
        }

        return 0;
    }

    private static boolean isMoved(int x, int y, int i){
        return 0 <= x && x < i && 0 <= y && y < i;
    }

    private static boolean isSame(Point i, Point j) {
        return i.x == j.x && i.y == j.y;
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
