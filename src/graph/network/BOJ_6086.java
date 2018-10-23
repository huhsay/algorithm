package graph.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 네트워크 유량문제
 * 파이프는 양방향이라는 점을 주위한다.
 */

public class BOJ_6086 {
    static int N;
    static int[][] capacity = new int[56][56];
    static int[][] flow = new int[56][56];
    static int[] parent = new int[56];
    static List<Integer>[] adj = new List[52];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 52 ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = alphaToInt(st.nextToken());
            int b = alphaToInt(st.nextToken());

            capacity[a][b] = capacity[b][a] += Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int S = alphaToInt("A");
        int E = alphaToInt("Z");
        int total = 0;

        while (true) {
            Arrays.fill(parent, -1);
            parent[S] = S;
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while (!q.isEmpty()) {
                int current = q.poll();
                if (current == E) break;

                for (int next : adj[current]) {
                    if (capacity[current][next] - flow[current][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = current;
                    }
                }
            } // augment

            // 더이상 경로가 없으면 알고리즘을 끝낸다.
            if (parent[E] == -1) break;

            int minFlow = 987654321;
            for (int i = E; i != S; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for (int i = E; i != S; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            total += minFlow;
        }

        System.out.print(total);
    }

    static int alphaToInt(String st) {
        char c = st.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        return c - 'a' + 26;
    }

}
