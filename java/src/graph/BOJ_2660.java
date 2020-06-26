package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2660 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1 ; j++) {
                if(!(i==j)) map[i][j] = n;
            }
        }

        String line = null;

        while(!(line = br.readLine()).equals("-1 -1")){
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n + 1 ; j++) {
                for (int k = 1; k < n + 1 ; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int[] cunt = new int[n+1];

        int min = n+1;
        for (int i = 1; i < n+1; i++) {
            int max = 0;
            for (int j = 1; j < n+1; j++) {
                max = Math.max(max, map[i][j]);
            }
            cunt[i] = max;
            min = Math.min(cunt[i], min);
        }

        StringBuilder people = new StringBuilder();

        int countNum = 0;
        for (int i = 1; i < n+1; i++) {
            if( cunt[i] == min ){
                people.append(i).append(" ");
                countNum++;
            }
        }

        System.out.println(min + " " + countNum);
        System.out.print(people);



    }
}
