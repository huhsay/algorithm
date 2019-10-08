package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = 1000000000;

        int mid;
        while( left < right ){

            mid = (left + right) / 2;

            if( canMove(a, b, v, mid) ) {
                right = mid;
            } else {
                left = mid +1;
            }
        }

        System.out.println(left);
    }

    private static boolean canMove(int a, int b, int v, int day) {
        long dif = a - b;

        return dif *(day-1) + a >= v;
    }
}
