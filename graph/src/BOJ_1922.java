import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922 {

    /**
     * 네트워크 연결
     * #greedy #graph #kruscal
     * www.acmipcp.net/problem/1992
     *
     */

    static int[] parent;
    static int nodeCnt;
    static int edgeCnt;
    static int cnt = 0;
    static int ans = 0;

    static class Edge implements Comparable<Edge>{

        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost>o.cost ? 1 : this.cost == o.cost ? 0 : -1 ;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCnt = Integer.parseInt(br.readLine());
        edgeCnt = Integer.parseInt(br.readLine());
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i=0; i<edgeCnt; i++){
            int x, y, cost;
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(x, y, cost));
        }

        Collections.sort(edges);

        parent = new int[nodeCnt+1];

        for(int i = 1; i <= nodeCnt; i++){
            parent[i]=i;
        }

        Edge temp;

        while( cnt != nodeCnt-1 ){
            temp = edges.remove(0);

            int x = temp.x;
            int y = temp.y;

            union(temp);
        }

        System.out.println(ans);

    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);// 이렇게 하면 리턴하면서 parent를 한번에 update 할 수 있다.
    }

    public static void union(Edge e){

        int x = e.x;
        int y = e.y;
        int cost = e.cost;

        int a = find(x);
        int b = find(y);

        if( a==b ) return;

        parent[b] = a;

        ans += cost;
        cnt++;

        /**
         * 양쪽 부모중에 하나에 추가하면 된다.
         * 부모가 한쪽에 부속되면 나머지도 나중에 find하는 과정에서 부모가 없데이트 되겠지..
         *
         * 부모를 바꿔주는 과정에서 변수를 두어 원하는 쪽으로 부모를 두게 할 수 있다.
         * (조건을 추가할 수 있다는 뜻이다.)
         */

    }
}
