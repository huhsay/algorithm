package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {

    static int[] array = new int[10];
    static int K;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            count += K / array[i];
            K = K % array[i];
        }

        System.out.println(count);
    }
}
