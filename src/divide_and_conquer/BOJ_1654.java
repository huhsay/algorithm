package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(bufferedReader.readLine());
        }

        long left = 1 ;
        long right = Integer.MAX_VALUE;
        long mid;

        while ( left < right) {
            mid = (long) Math.ceil( (left + right) / 2.0);

            if( makeLinke(lines, n, mid)){
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println( left );
    }

    private static boolean makeLinke(int[] lines, int n, long target) {
        int count = 0;
        for (int a : lines) {
            count += a / target;
        }

        return count >= n;
    }
}
