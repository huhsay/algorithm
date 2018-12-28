package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            PriorityQueue<Integer> priority = new PriorityQueue<>();
            Queue<Point> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());

                list.add(new Point(i, temp));
                priority.add(-temp);
            }

            int count = 0;

            int maxPriority;
            Point current;
            while(true){
                maxPriority = -priority.peek();
                current = list.peek();

                if(current.priority == maxPriority){
                    count++;
                    priority.poll();
                    list.poll();
                    if(current.index == M){
                        System.out.println(count);
                        break;
                    }
                    continue;
                }

                list.add(list.poll());
            }
        }
    }

    static class Point{
        int index;
        int priority;

        public Point(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
