package etc;

/*
    ㅋㅏ카오 코드 패스티벌 상금헌터
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int first, second;
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            System.out.println(compute(first, second));
        }
    }

    public static int compute(int first, int second) {
        int award = 0;

        if( first == 1) {
            award += 5000000;
        }else if ( 1 < first && 3 >= first) {
            award += 3000000;
        } else if ( 3 < first && 6 >= first) {
            award += 2000000;
        } else if ( 6 < first && 10 >= first) {
            award += 500000;
        } else if ( 10 < first && 15 >= first) {
            award += 300000;
        } else if ( 15 < first && 21 >= first) {
            award += 100000;
        }

        if( second == 1) {
            award += 5120000;
        }else if ( 1 < second && 3 >= second) {
            award += 2560000;
        } else if ( 3 < second && 7 >= second) {
            award += 1280000;
        } else if ( 7 < second && 15 >= second) {
            award += 640000;
        } else if ( 15 < second && 31 >= second) {
            award += 320000;
        }

        return award;
    }
}
