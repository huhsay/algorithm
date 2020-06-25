package etc;

import java.util.Scanner;

public class BOJ_14761 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int X  = sc.nextInt();
        int Y = sc.nextInt();
        int N = sc.nextInt();

        fizzbuzz(X, Y, N);
    }

    public static void fizzbuzz(int x, int y, int n){
        for (int i = 1; i <= n; i++) {
            String word = toWord(x, i, "Fizz") + toWord(y, i, "Buzz");

            if(word.isEmpty()){
                System.out.println(Integer.toString(i));
            }else{
                System.out.println(word);
            }
        }
    }

    private static String toWord(int divisor, int i, String word) {
        return i % divisor == 0 ? word : "" ;
    }
}
