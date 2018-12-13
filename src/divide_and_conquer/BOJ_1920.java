package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if(binarySearch(nArray, temp) < 0){
                System.out.println("0");
            }else{
                System.out.println("1");
            }
        }
    }

    public static int binarySearch(int[] numbers, int number){

        int left = 0;
        int right = numbers.length-1;
        int mid = 0;

        while(left <= right){
            mid = (int) Math.ceil((left + right) / 2);

            int temp = numbers[mid];

            if( temp < number){
                left = mid + 1;
            }else if( temp > number){
                right = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
