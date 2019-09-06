package brutforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int[] cards = new int[101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    sum = 0;
                    sum = cards[i] + cards[j] + cards[k];

                    if(sum <= M && max < sum) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);

    }
}
