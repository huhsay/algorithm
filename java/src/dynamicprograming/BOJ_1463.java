package dynamicprograming;

import java.util.Scanner;

public class BOJ_1463 {
    static int count = 0;
    static int[] dp = new int[1000000];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        int count = 4;
        while(count <= x){

            int temp = 987654321;

            if( count%3 == 0){
                temp = Math.min(dp[count/3], temp);
            }
            if( count%2 == 0){
                temp = Math.min(dp[count/2], temp);
            }

            temp = Math.min(dp[count-1], temp);

            dp[count] = temp+1;
            count++;
        }
        System.out.println(dp[x]);
    }
}
