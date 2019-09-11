package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 1992 쿼드트리
    재귀를 사용
 */

public class BOJ_1992 {
    public static StringBuilder sb ;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new char[65][65];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solve(0, 0, N);

        System.out.println(sb.toString());

    }

    static public void solve(int x, int y, int length) {
        if (length == 1) {
            sb.append(map[x][y]);
            return;
        }


        if (isSame(x, y, length)) {
            sb.append(map[x][y]);
        } else {
            sb.append("(");
            int nextLength = length/2;
            solve(x, y, nextLength);
            solve(x, y+nextLength, nextLength);
            solve(x+nextLength, y, nextLength);
            solve(x+nextLength, y+nextLength, nextLength);
            sb.append(")");
        }
    }

    static public boolean isSame(int x, int y, int length) {

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (map[x][y] != map[i][j]) return false;
            }
        }
        return true;
    }

}
 