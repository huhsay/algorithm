import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1486 {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] graph = new int[N*M][N*M];
        for (int i = 0; i < N*M; i++) {
            for (int j = 0; j < N*M; j++) {
                if(i==j) continue;
                graph[i][j] = 987654321;
            }
        }
        for (int n = 0; n < N ; n++) {
            for (int m = 0; m < M; m++) {
                int start = n*M+m;
                for (int k = 0; k < 4; k++) {

                    int y = n + dy[k];
                    int x = m + dx[k];

                    if( x < 0 || x >= M || y < 0 || y >= N) continue;
                    int end = y*M + x;

                    int diff = charToInt(n, m) - charToInt(y, x);

                    if(Math.abs(diff) > T) continue;
                    if(diff < 0){
                        graph[start][end] = diff*diff;
                    }else{
                        graph[start][end] = 1;
                    }
                } // for
            }
        }

        // floyd
        for (int i = 0; i < N*M ; i++) {
            for (int j = 0; j < N*M; j++) {
                for (int k = 0; k < N*M ; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N*M; i++) {
            if(graph[0][i] + graph[i][0] <= D){
                ans = Math.max(ans, charToInt(i/N, i%M));
            }
        }

        System.out.print(ans);


    }

    static int charToInt(int a, int b){
        if( 'A' <=map[a][b] && 'Z' >= map[a][b]){
            return map[a][b] - 65;
        }else{
            return map[a][b] - 'a' + 26;
        }
    }
}
