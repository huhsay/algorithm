package graph;

import java.io.*;
import java.util.StringTokenizer;

/*
    백준 11403 경로 찾기
    플로이드 와샬 / dfs
    업데이트를 하는 부분의 조건이 중요하다.
 */

public class BOJ_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken(" "));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][i] == 1 && map[i][k] == 1) map[j][k] = 1;
                }
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            bufferedWriter.write(sb.toString());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
