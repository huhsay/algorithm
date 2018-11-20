package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1931 {
    static int N;
    static long lastTime;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long from;
        long to;

        PriorityQueue<Point> q = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            from = Long.parseLong(st.nextToken());
            to = Long.parseLong(st.nextToken());
            q.add(new Point(from, to));
        }
        int ans = 0;
        lastTime = 0;

        while(!q.isEmpty()){
            Point current = q.poll();
            if(!isVisit(current)){
                lastTime = current.to;
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isVisit(Point newPoint) {

        if( newPoint.from < lastTime) return true;

        return false;
    }

    private static class Point implements Comparable<Point> {
        long from;
        long to;

        public Point(Long from, Long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Point o) {
            return this.to < o.to ? -1 : this.to == o.to ? this.from < this.to ? -1 : 1 : 1 ;        }
    }
}
