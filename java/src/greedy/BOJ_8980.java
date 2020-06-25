package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_8980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        Queue<Point> q = new PriorityQueue<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.add(new Point(a, b, c));
        }

        int[] town = new int[2001];

        int ans = 0;
        while(!q.isEmpty()) {

            Point temp =q.poll();

            int available = temp.value;
            for (int i = temp.start+1; i <= temp.end ; i++) {
                available = Math.min(available, C-town[i]);
            }

            for (int i = temp.start+1; i <= temp.end; i++) {
                town[i] += available;
            }

            ans += available;
        }

        System.out.println(ans);
    }

    static class Point implements Comparable{
        private int start;
        private int end;
        private int value;

        public Point(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Object o) {
            if( end - ((Point)o).end > 0 ){
                return 1;
            } else if(end - ((Point)o).end < 0){
                return -1;
            } else{
                return start - ((Point)o).start;
            }
        }
    }
}
