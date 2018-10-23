package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2188 {
    static StringTokenizer st;
    static final int MAX = 500;

    static int N; // 200
    static int M; // 200
    static int[] parent = new int[402];
    static int[][] capacity = new int[402][402];
    static int[][] flow = new int[402][402];
    static ArrayList<Integer>[] graph = new ArrayList[402];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M + 2; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int to = N + Integer.parseInt(st.nextToken());
                graph[i].add(to);
                graph[to].add(i);
                capacity[i][to] = MAX;
            }
        }

        int s = 0;
        int t = N + M + 1;

        for (int i = 1; i < N + 1; i++) {
            graph[s].add(i);
            capacity[s][i] = 1;
        }

        for (int i = N + 1; i < t; i++) {
            graph[i].add(t);
            capacity[i][t] = 1;
        }

        int total = 0;

        while (true) {
            Arrays.fill(parent, -1);
            parent[s] = s;
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            while (!q.isEmpty()) {
                int current = q.poll();
                if (current == t) break;

                for (int next : graph[current]) {
                    if (capacity[current][next] - flow[current][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = current;
                    }
                }
            }// augment

            if (parent[t] == -1) break;

            for (int i = t; i != s; i = parent[i]) {
                flow[parent[i]][i] += 1;
                flow[i][parent[i]] -= 1;
            }

            total += 1;

        }

        System.out.println(total);

    }

}
