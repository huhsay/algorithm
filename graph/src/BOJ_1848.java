import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1848 {

    public static void main(String args[]) throws IOException {
        final int INF = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] map = new List[n + 1];

        int[] z = new int[n+1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(a==1){
                z[b] = c;
            }

            if(b==1){
                z[a] = d;
            }

            map[a].add(new Edge(b, d));
            map[b].add(new Edge(a, c));


        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.remove();

            for (int i = 0; i < map[current.vertex].size(); i++) {
                Edge next = map[current.vertex].get(i);

                if (dist[next.vertex] > dist[current.vertex] + next.value) {
                    dist[next.vertex] = dist[current.vertex] + next.value;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }

            }
        }

        int min = INF;
        for(int i = 2; i <= n; i++){
            dist[i] = dist[i] + z[i];

            if(dist[i] < min) min = dist[i];
        }

        System.out.println(min);

    }


    static class Edge implements Comparable<Edge>{
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.vertex > o.vertex ? -1:1;
        }
    }
}
