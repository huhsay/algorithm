package brutforce;

import java.util.Scanner;
/* 백준 1436 영화감독 숌
   탐색 brutforce
   2019.09.07
 */

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 0;
        int number = 0;

        while(count < N){
            number++;

            // 직접 하나씩 확인 하는 식으로 구현가능
            if(String.valueOf(number).contains("666")){
                count++;
            }
        }

        System.out.print(number);
    }
}
