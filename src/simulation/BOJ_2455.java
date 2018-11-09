package simulation;

import java.util.Scanner;

public class BOJ_2455 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int current = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int off = sc.nextInt();
            int on = sc.nextInt();
            sc.nextLine();

            current = current + on - off;
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
