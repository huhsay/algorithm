package etc;

import java.io.*;
import java.util.StringTokenizer;

/*
    백준 13458 삼 시험감독
    int 범위 잘 생각하기
 */

public class BOJ_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, B, C;
        int A[];

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int temp;
        long count = 0;
        for (int i = 0; i < N; i++) {
            temp = A[i] - B;
            ++count;

            if( temp < 0) continue;

            if ( temp % C > 0) ++count;

            count += temp / C ;
        }
        System.out.println(count);
    }
}
