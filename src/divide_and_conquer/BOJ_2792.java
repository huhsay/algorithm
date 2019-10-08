package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] jerms = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            jerms[i] = Integer.parseInt(br.readLine());

            if (jerms[i] > max) {
                max = jerms[i];
            }
        }

        int left = 1;
        int right = max;
        int mid = 0;
        int temp = 0;
        int answer = 0;
        while (left < right) {
            mid = (left + right) / 2;

            temp = countStudent(jerms, mid);

            if ( temp <= N ) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println( left );
    }

    private static int countStudent(int[] jerms, int target) {
        int count = 0;
        for (int i = 0; i < jerms.length; i++) {
            count += jerms[i] / target;
            if( jerms[i] % target > 0) count++;
        }
        return count;
    }

    private static int max(int[] jerms, int target) {
        int max = 0;

        int temp = 0;
        for (int a : jerms){
            if(a % target > 0) {
                temp = target + (a % target);
                if( temp > max) {
                    max = temp;
                }
            }

        }

        return max;
    }


}
