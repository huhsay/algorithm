package brutforce;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    static final int MAX = 1000000000;
    static int[] inputArray;

    public static void main(String[] args) throws IOException {
        int N, L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > temp){
                deque.removeLast();
            }
            deque.addLast(new Node(temp, i));

            if(deque.getFirst().index <= i-L){
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
