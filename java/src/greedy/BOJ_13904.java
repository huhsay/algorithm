package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13904 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] deadline = new boolean[1001];

        Queue<Point> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            q.add(new Point(a, b));
        }

        int totalValue = 0;

        A:
        while(!q.isEmpty()){
            Point temp = q.poll();

            int date = temp.date;
            while(deadline[date]){
                date--;
                if(date<=0) continue A;
            }

            totalValue += temp.getValue();
            deadline[date] = true;
        }

        System.out.println(totalValue);

    }

    static class Point implements Comparable {
        private int value;
        private int date;

        public Point(int date, int value) {
            this.value = value;
            this.date = date;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        @Override
        public int compareTo(Object o) {
            return ((Point)o).value - this.value;
        }
    }
}
