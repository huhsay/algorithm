package graph;

import javafx.scene.effect.InnerShadow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {
    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] map = new int[V+1][V+1];

        for (int i = 1; i < V+1; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }

        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                for (int k = 1; k < V+1; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]);
                }
            }
        }

        int min = INF;
        for (int i = 1; i < V+1; i++) {
            min = Math.min(min, map[i][i]);
        }

        System.out.println(min==INF ? -1 : min);


    }
}
