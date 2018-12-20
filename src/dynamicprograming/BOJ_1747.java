package dynamicprograming;

import java.util.Scanner;

public class BOJ_1747 {

    final static int MAX = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = N; i <= MAX; i++) {
            if (isPrimNumber(i))
                if (isPalindromeNumber(i)) {
                    System.out.println(i);
                    return;
                }
        }
    }

    private static boolean isPrimNumber(int number) {

        if (number == 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    static public boolean isPalindromeNumber(int number) {

        char[] numberArray = String.valueOf(number).toCharArray();

        for (int i = 0; i < numberArray.length / 2; i++) {
            if (numberArray[i] != numberArray[numberArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}