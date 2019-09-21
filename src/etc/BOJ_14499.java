package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    백준 14499 주사위굴리기 삼성
    이차원 배열에서 x,y의 인덱스 값에 주의한다.
    주사위가 굴러가는 구현을 어떻게 할 것인가!
 */

public class BOJ_14499 {

    static int[] dice = new int[7];
    static int[][] map;
    static int x;
    static int y;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int direction = Integer.parseInt(st.nextToken());

            moveDice(direction);
        }

    }

    private static void moveDice(int direction) {

        int temp = 0;
        switch (direction) {
            case 1:
                y++;
                if (y >= M) {
                    y--;
                    return;
                }
                temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;

            case 2:
                y--;
                if (y < 0) {
                    y++;
                    return;
                }
                temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;

            case 3:
                x--;
                if (x < 0) {
                    x++;
                    return;
                }
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;

                break;

            case 4:
                x++;
                if (x >= N) {
                    x--;
                    return;
                }
                temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }


        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[1]);

    }
}
