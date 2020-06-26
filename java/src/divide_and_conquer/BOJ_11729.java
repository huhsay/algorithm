package divide_and_conquer;

import java.util.Scanner;

public class BOJ_11729 {
    static int moveCount = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println((int)Math.pow(2, N)-1);
        move(N, 1, 2, 3);
    }

    private static void move(int number, int from, int by, int to) {
        if(number==1){
            System.out.println(String.format("%d %d", from, to));
        } else {
            move(number-1, from, to, by);
            System.out.println(String.format("%d %d", from, to));
            moveCount++;
            move(number-1, by, from, to);
        }
    }
}
