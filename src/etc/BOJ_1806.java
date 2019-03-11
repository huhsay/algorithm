package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    static int MAX = 100001;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        int left = -1;
        int right = -1;
        int length = MAX;
        int sum = 0;

        while(left < N-1 || right < N-1){

            if(right >= N-1 || sum >= S){
                left++;
                sum -= inputArray[left];
            }else{
                right++;
                sum += inputArray[right];
            }

            if(sum >= S){
                length = Math.min(length, right-left);
            }

        }

        if(length == 100001){
            length = 0;
        }
        System.out.println(length);
    }
}
