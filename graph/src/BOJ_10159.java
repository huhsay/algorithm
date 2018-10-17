import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159 {

    /**
     *  floyd warshall로 해결
     *  삼중 for문 안에서 알고리즘을 수정해야 할 때도 있고,
     *  알고리즘 결과를 해석 해야하는 경우도 있다.
     *  이문제 같은경우, 크기가 작고 크고를 모두 그래프에 표현하려하지 말고
     *  크기가 큰경우만 설정하면, 비교가능한지 구할 수 있다.
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = true;
        }

//        for (int i = 0; i < N; i++) {
//                graph[i][i] = true;
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    graph[j][k] |= graph[j][i] & graph[i][k];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int count = -1;
            for (int j = 0; j < N; j++) {
                if(!graph[i][j] && !graph[j][i]) count++;
            }
            System.out.println(count);
        }
    }
}
