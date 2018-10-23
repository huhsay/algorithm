package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static int MAX_TIME = 99000;

    static int[][] d;
    static int N; // the number of student
    static int M; // the number of road
    static int X; // goal index


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // init
        N = readInt();
        M = readInt();
        X = readInt();
        d = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            Arrays.fill(d[i], MAX_TIME);
            d[i][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            int fromIndex = readInt();
            int toIndex = readInt();
            int value = readInt();

            d[fromIndex][toIndex] = value;
        }

        floyd();

        // solve
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            max = Math.max(max , d[i][X] + d[X][i]);
        }

        // print
        System.out.println(max);
    }

    static void floyd() {

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    d[i][j] = d[i][j] > d[i][k] + d[k][j] ? d[i][k] + d[k][j] : d[i][j];
                }
            }
        }

    }

    static int readInt() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }

        return Integer.parseInt(st.nextToken());
    }
}
