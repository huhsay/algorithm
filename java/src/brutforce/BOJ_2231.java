package brutforce;

import java.util.Scanner;

public class BOJ_2231 {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i = 0; i < 1000000; i++) {
            if(number == cal(i)){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }

    static int cal(int i){
        int sum = i;
        while(i != 0){
            sum += i%10;
            i = i/10;
        }

        return sum;
    }
}
