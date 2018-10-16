import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1613 {
    static final int INF = 987654321;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n+1][n+1];


        for (int i = 0; i < k ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                for (int l = 1; l < n+1; l++) {
                    map[j][l] |= map[j][i] & map[i][l];
                }
            }
        }

        int temp = Integer.parseInt(br.readLine());

        for (int i = 0; i < temp; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( map[a][b]) { System.out.println(-1); continue;}
            if( map[b][a]) { System.out.println(1); continue;}
            System.out.print(0);
        }
    }
}
