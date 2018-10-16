import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2224 {
    final static int MAX = 58;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[MAX][MAX];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " => ");
            int a = st.nextToken().charAt(0) - 65;
            int b = st.nextToken().charAt(0) - 65;

            map[a][b] = true;
        }

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                for (int k = 0; k < MAX; k++) {
                    map[j][k] |= map[j][i] & map[i][k];
                }
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if(i==j) continue;
                if (map[i][j]) {
                    cnt++;
                    sb.append((char) ('A' + i)).append(" => ").append((char) ('A' + j)).append("\n");
                }
            }
        }

        System.out.println(cnt);
        System.out.print(sb);

    }

}
