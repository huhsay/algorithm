package simulation;

import java.util.Scanner;

public class BOJ_1057 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count=0;
        while(x!=y){
            x = x/2 + x%2;
            y = y/2 + y%2;
            count++;
        }

        System.out.println(count);
    }
}
