package datastructure.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
    백준 1021 회전하는 큐
    덱 개념을 이용
    왼쪽으로 움직이는 것과 오른쪽으로 움직이는 것을 비교하는 것이 즁요
 */

public class BOJ_1021 {
    static LinkedList<Integer> circleQueue = new LinkedList<>();
    static int count = 0;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());


        for (int i = 1; i <= M; i++) {
            circleQueue.add(i);
        }

        seq = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solve();

        System.out.println(count);


    }

    static public int solve() {

        for (int i = 0; i < seq.length; i++) {

            move(seq[i]);

        }

        return count;
    }

    static public void move(int target) {
        int index = circleQueue.indexOf(target);
        int left = index;
        int right = circleQueue.size() - index;

        if(index == 0){
            circleQueue.removeFirst();
            return;
        }else if( left <= right) {
            count += left;
            for (int i = 0; i < left; i++) {
                circleQueue.addLast(circleQueue.removeFirst());
            }
            circleQueue.removeFirst();
        }else {
            count += right;
            for (int i = 0; i < right; i++) {
                circleQueue.addFirst(circleQueue.removeLast());
            }
            circleQueue.removeFirst();
        }
    }
}
