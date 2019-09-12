package datastructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();

        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());

            if(temp == 0) {
                if( queue.isEmpty() ) {
                    System.out.println("0");
                } else {
                    System.out.println(-queue.poll());
                }

            } else {
                queue.add(-temp);
            }

        }
    }
}
