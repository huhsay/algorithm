package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    백준 12761 돌다리
    bfs

 */

public class BOJ_12761 {

    static int[] visited = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());


        queue.add(N);
        visited[N] = 1;

        int current = 0;
        int next = 0;
        int count = 0;
        while ( !queue.isEmpty() ) {
            current = queue.poll();
            count = visited[current];

            if( current == M ) break;

            // 1
            next = current - 1;
            addIf(next, count);

            // 2
            next = current + 1;
            addIf(next, count);

            // 3
            next = current + A;
            addIf(next, count);

            // 4
            next = current - A;
            addIf(next, count);

            // 5
            next = current + B;
            addIf(next, count);

            // 6
            next = current - B;
            addIf(next, count);

            // 7
            next = current * A;
            addIf(next, count);

            // *
            next = current * B;
            addIf(next, count);

        }

        System.out.println(visited[M]-1);
    }

    public static void addIf(int next, int count) {
        if(isMoved(next) && visited[next] == 0) {
            queue.add(next);
            visited[next] = ++count;
        }
    }

    public static boolean isMoved(int next) {
        if( next < 0) return false;
        if( next > 100000) return false;
        return true;
    }
}

