package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2912 {
    static int N;
    static int C;
    static int[] n;
    static int[] hat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        n = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int m = 0; m < M; m++) {
            hat = new int[C+1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean isPretty = false;

            for (int i = start; i <= end ; i++) {
                int index = n[i];
                hat[index]++;

                if(hat[index] > (end-start+1)/2){
                    System.out.println("yes " + index);
                    isPretty = true;
                    break;
                }
            }

            if(!isPretty){
                System.out.println("no");
            }
        }
    }
}
