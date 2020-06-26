package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    static int[] day = new int[100000];
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int min = 0;
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            min = Math.max(day[i], min);
        }
        biSearch(min, 1000000);

        System.out.println(K);

    }

    private static void biSearch(int from, int to) {
        int mid = (from + to) / 2;

        int m = count(mid);

        if(from >= to){
            K = from;
            return;
        }

        if( m <= M){
            biSearch(from, mid);
        }else{
            biSearch(mid +1, to);
        }
    }

    private static int count(int mid){
        int cnt = 1;
        int current = mid;

        for (int i = 0; i < N; i++) {
            if( day[i] > current){
                current = mid;
                cnt++;
            }
            current -= day[i];
        }

        return cnt;
    }
}
