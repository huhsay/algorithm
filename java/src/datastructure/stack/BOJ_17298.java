package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    백준 17298 오큰수
    스택
    시간초과
 */

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[1000001];
        int[] answer = new int[1000001];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            array[i] = temp;

            for (int j = 1; j <= i; j++) {
                if( answer[j] != 0) continue;

                if( array[j] < temp) {
                    answer[j] = temp;
                }

            }
        }

        for (int i = 1; i <= N; i++) {

            if( answer[i] == 0) {
                System.out.print("-1 ");
                continue;
            }
            System.out.printf("%d ", answer[i]);
        }
    }
}
