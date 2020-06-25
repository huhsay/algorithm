package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {

    static int[] array = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            array[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array,0,N);

        int max = 0;

        for (int i = 0; i < N; i++) {
            if(max < array[i]*(N-i)){
                max = array[i]*(N-i);
            }
        }

        System.out.println(max);
    }
}
