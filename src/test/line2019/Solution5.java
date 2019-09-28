package test.line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        int[][] map = new int[26][26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[0][0] = 1;

        for (int i = 0; i <= x + y + 1; i++) {
            for (int j = 0; j <= y; j++) {

                int k = i - j;

                if(k >=0 && k <= x && j >= 0 && j <= y) {
                    if (k - 1 >= 0) map[j][k] = map[j][k - 1];
                    if (j - 1 >= 0) map[j][k] += map[j - 1][k];
                }
            }
        }

        System.out.println( x + y );
        System.out.println(map[y][x]);
        
    }
}

