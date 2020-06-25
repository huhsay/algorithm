package datastructure.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/*
    백준 2164 카드2
    단순 덱 개념 익히기
 */
public class BOJ_2164 {

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }


        while(deque.size() != 1){
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        bufferedWriter.write(deque.removeFirst());

        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
