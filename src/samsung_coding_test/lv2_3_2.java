package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class lv2_3_2 {
    static int T;
    static int N;
    static PriorityQueue<Point> stores;
    static Queue<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 식당개수 max 200,000

            stores = new PriorityQueue<>();
            answer = new LinkedList<>();

            // store 좌표 input
            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());

                stores.add(new Point(n, tempX, tempY));
            }

            solve();

            System.out.println("#" + t + " " + toStringSkyLine());

        }
    }

    static void solve() {

        Point temp;
        int maxY = 1000000000;
        int maxX = 0;
        while (!stores.isEmpty()) {
            temp = stores.poll();

            if (temp.x > maxX && temp.y < maxY) {
                answer.add(temp.number);
                maxX = temp.x;
                maxY = temp.y;
            }
        }
    }

    static String toStringSkyLine() {

        StringBuilder sb = new StringBuilder();
        while (!answer.isEmpty()) {
            sb.append(answer.poll()).append(" ");
        }

        return sb.toString().trim();
    }

    private static class Point implements Comparable<Point> {
        int number;
        int x;
        int y;

        public Point(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int temp = this.x - o.x;
            if (temp < 0) {
                return -1;
            } else if (temp == 0) {
                return this.y - o.y;
            } else {
                return 1;
            }
        }
    }
}
