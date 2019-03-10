package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

    public static void main(String[] args) throws IOException {
        int M;
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, inputArray[i]);
        }

        int low = 0;
        int high = max;
        int currentH = 0;

        while(low <= high){
            long sum = 0;

            currentH = (low+high) / 2;

            for (int i = 0; i < N; i++) {
                if(inputArray[i] <= currentH) continue;

                sum += inputArray[i] - currentH;
            }

            if(sum >= M){
                low = currentH+1;
            }else{
                high = currentH-1;
            }
        }

        System.out.println(high);

    }
}
