import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504 {

    static final int INF = 800000;
    static List<Edge>[] map;
    static int node;
    static int edge;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        map = new ArrayList[node+1];

        for(int i = 1; i <= node ; i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 1; i <= edge ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, value));
            map[to].add(new Edge(from, value));
        }

        st = new StringTokenizer(br.readLine());

        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        int result1 = dijk(1, mid1) + dijk(mid1, mid2) + dijk(mid2, node);
        int result2 = dijk(1, mid2) + dijk(mid2, mid1) + dijk(mid1, node);

        if(result1 >= INF && result2 >= INF){
            System.out.println(-1);
            return;
        }

        if (result1 > result2) {
            System.out.println(result2);
        } else {
            System.out.println(result1);
        }
    }

    static int dijk(int start, int finish){

        if(start == finish) return 0;

        int[] dist = new int[node+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if(current.to==finish) return dist[current.to];

            for(int i = 0; i < map[current.to].size(); i++){
                Edge next = map[current.to].get(i);

                if(dist[next.to] > dist[current.to] + next.value){
                    dist[next.to] = dist[current.to] + next.value;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        } //while

        return INF;
    }

    static class Edge implements Comparable<Edge>{
        int to;
        int value;

        public Edge(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value>o.value ? 1:-1;
        }
    }
}
