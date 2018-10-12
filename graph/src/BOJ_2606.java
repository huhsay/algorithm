import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int ans =0;
        visit[1] = true;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (int i = 1; i <= N; i++) {
                if(map[current][i]==1){
                    if(!visit[i]){
                        visit[i] = true;
                        pq.add(i);
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
