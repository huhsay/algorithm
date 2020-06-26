package datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1];
        LinkedList<Integer>[] graph = new LinkedList[N + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);

        }

        queue.add(1);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();

            while (!graph[currentIndex].isEmpty()) {
                int nextIndex = graph[currentIndex].poll();
                if (parent[nextIndex] != 0) continue;

                parent[nextIndex] = currentIndex;
                queue.add(nextIndex);
            }

        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }
}
