import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159 {

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
