import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1219 {

    public static void main(String args[]) throws IOException {
        final int INF = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int finish = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, value));
        }

        st = new StringTokenizer(br.readLine());

        int[] gain = new int[n];
        int index = 0;
        while (st.hasMoreTokens()) {
            gain[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        int[] sumCost = new int[n];
        Arrays.fill(sumCost, INF);
        sumCost[start] = 0;
        int[] sumGain = new int[n];
        int[] sum = new int[n];

        int b = 0;
        boolean f = false;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    int to = graph[j].get(k).vertex;
                    int cost = graph[j].get(k).value;
                    if (sum[to] > sum[j] - cost + gain[to]) {
                        sum[to] = sum[j] - cost + gain[to];
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                int to = graph[j].get(k).vertex;
                int cost = graph[j].get(k).value;

                if (sum[to] > sum[j] - cost + gain[to]) {
                    f = true;
                }
            }
        }


//        if (sumCost[finish] == INF) {
//            System.out.println("gg");
//        }
//
//        if (f){
//            System.out.print(-sumCost[finish]);
//        }
//
//        if (b) {
//
//        }

    }

    static class Edge {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}
