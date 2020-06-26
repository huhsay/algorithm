package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class lv2_3 {
    static int T;
    static int N;
    static LinkedList<Point> stores;
    static boolean[] skyLine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 식당개수 max 200,000
            stores = new LinkedList<>();
            skyLine = new boolean[N + 1];
            Arrays.fill(skyLine, true);
            skyLine[0] = false;

            // store 좌표 input
            for (int n = 1; n <= N; n++) {
                st = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());

                stores.add(new Point(n, tempX, tempY));
            }

            Collections.sort(stores);

            solve();

            System.out.println("#" + t + " " + toStringSkyLine());

        }
    }

    static void solve() {

        Point current;
        Point temp;

        for (int i = 0; i < stores.size(); i++) {

            current = stores.get(i);
            if (!skyLine[current.number]) continue;
            for (int j = i + 1; j < stores.size(); j++) {

                temp = stores.get(j);

                if (!skyLine[temp.number]) continue;
                if (current.x == temp.x && current.y < temp.y) {
                    skyLine[temp.number] = false;
                    continue;
                }

                if (current.y == temp.y && current.x < temp.x) {
                    skyLine[temp.number] = false;
                    continue;
                }

                if (current.x < temp.x && current.y < temp.y) {
                    skyLine[temp.number] = false;
                    continue;
                }
            }
        }
    }

    static String toStringSkyLine() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (skyLine[stores.get(i).number]) {
                sb.append(stores.get(i).number).append(" ");
            }
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
