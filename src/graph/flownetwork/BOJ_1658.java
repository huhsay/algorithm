package graph.flownetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1658 {
    static final int INF = 87654321;
    static final int MAX_IND = 102102;

    static List<Integer>[] adj = new List[MAX_IND];
    static int[][] residual = new int[MAX_IND][MAX_IND];
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int source = 0;
        int sink = M * (N + 1) + 1;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < MAX_IND; i++) {
            adj[i] = new ArrayList<>();
        }

        // 우리안 돼지 수
        for (int i = 1; i <= M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            residual[source][i] = temp;
            adj[source].add(i);
            adj[i].add(source);
        }

        // 네트워크 만들기
        for (int day = 1; day <= N; day++) {
            st = new StringTokenizer(br.readLine());
            int numberOfKey = Integer.parseInt(st.nextToken());

            // 사람이 가지고 있는 키 받기
            int[] key = new int[numberOfKey];
            for (int k = 0; k < numberOfKey; k++) {
                key[k] = Integer.parseInt(st.nextToken());
            }

            // 사람이 사고싶은 돼지의 량
            int capacity = Integer.parseInt(st.nextToken());

            // from sink to  supersink
            residual[M * N + day][sink] = capacity;
            adj[M * N + day].add(sink);
            adj[sink].add(M * N + day);

            for (int i = 0; i < numberOfKey; i++) {
                int fromKey = key[i];

                // 날마다 sink로 가는길
                residual[(day - 1) * M + fromKey][M * N + day] = INF;
                adj[(day - 1) * M + fromKey].add(M * N + day);
                adj[M * N + day].add((day - 1) * M + fromKey);

                if (day == N) continue;

                // 다음날을 위한 준비 우리 섞기
                for (int j = 0; j < numberOfKey; j++) {
                    int toKey = key[j];
                    if (fromKey == toKey) continue;
                    residual[(day - 1) * M + fromKey][day * M + toKey] = INF;
                    adj[(day - 1) * M + fromKey].add(day * M + toKey);
                    adj[day * M + toKey].add((day - 1) * M + fromKey);
                }
            } //key

            if (day == N) continue;
            //다음날 자신의 우리로 가는 간선
            for (int i = 1; i <= M; i++) {
                residual[(day - 1) * M + i][day * M + i] = INF;
                adj[(day - 1) * M + i].add(day * M + i);
                adj[day * M + i].add((day - 1) * M + i);
            }


        } //day

        // 포드풀커슨 돌리기
        int[] parent = new int[MAX_IND];
        int totalFlow = 0;

        while (true) {
            Arrays.fill(parent, -1);
            parent[source] = source;
            Queue<Integer> q = new LinkedList<>();
            q.add(source);

            while (!q.isEmpty()) {
                int current = q.poll();
                if (current == sink) break;

                for (int next : adj[current]) {
                    if (residual[current][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = current;
                    }
                }
            } //augment

            if (parent[sink] == -1) break; // 더이상 남은 용량이 없다면 알고리즘 끝

            int minFlow = INF;
            for (int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, residual[parent[i]][i]);
            }

            // flow 갱신하기
            for (int i = sink; i != source; i = parent[i]) {
                residual[parent[i]][i] -= minFlow;
                residual[i][parent[i]] += minFlow;
            }

            totalFlow += minFlow;
        }

        System.out.print(totalFlow);

    }
}
