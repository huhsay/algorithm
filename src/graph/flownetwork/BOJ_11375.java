package graph.flownetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 열혈강호2 백준
 * 플로우 네트워크
 */

public class BOJ_11375 {
    static final int MAX = 1000 + 1000 + 2;
    static final int INF = 654321;

    static List<Integer>[] adj = new List[MAX];
    static int[][] residual = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람
        int M = Integer.parseInt(st.nextToken()); // 해야할일

        int source = 0;
        int sink = N + M + 1;

        for (int i = 0; i <= sink ; i++) {
            adj[i] = new ArrayList<>();
        }

        // super source to source
        for (int i = 1; i <= N; i++) {
            residual[source][i] = 2;
            adj[source].add(i);
            adj[i].add(source);
        }

        // sink to super sink
        for (int i = N + 1; i <= M + N; i++) {
            residual[i][sink] = 1;
            adj[i].add(sink);
            adj[sink].add(i);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());

            for (int j = 0; j < temp; j++) {
                int to = Integer.parseInt(st.nextToken());
                residual[i][to+N] = INF;
                adj[i].add(to+N);
                adj[to+N].add(i);
            }
        }

        int total = 0;
        int[] parent = new int[sink+1];

        while (true) {
            Arrays.fill(parent, -1);
            parent[source] = source;
            Queue<Integer> q = new LinkedList<>();
            q.add(source);

            while (!q.isEmpty()) {
                int current = q.poll();
                if (current == sink) break;

                for (int next : adj[current]) {
                    if(residual[current][next] > 0 && parent[next] == -1){
                        q.add(next);
                        parent[next] = current;
                    }
                }
            } //augment

            if ( parent[sink] == -1) break;

            /*
            int minFlow = INF;
            for (int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, residual[parent[i]][i]);
            }
            */

            for (int i = sink; i != source ; i = parent[i]) {
                residual[parent[i]][i] -= 1;
                residual[i][parent[i]] += 1;
            }

            total += 1;
        }

        System.out.print(total);


    }
}
