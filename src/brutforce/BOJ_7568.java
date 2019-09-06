package brutforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {

        int[][] people = new int[51][2];
        int[] answer = new int[51];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if( i == j ) continue;

                if ( people[i][0] < people[j][0] && people[i][1] < people[j][1] ) {
                    answer[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", answer[i]+1);
        }
    }
}
