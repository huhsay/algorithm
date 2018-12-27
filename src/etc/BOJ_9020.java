package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9020 {
    final static int MAX = 10001;
    public static boolean[] primeNumber = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        calculatePrimeNumber();

        for (int t = 0; t < T; t++) {
            goldBachPartition(Integer.parseInt(br.readLine()));
        }
    }

    public static void calculatePrimeNumber(){

        Arrays.fill(primeNumber, true);
        primeNumber[0] = primeNumber[1] = false;
        for (int i = 2; i < MAX; i++) {
            if(primeNumber[i]){
                for (int j = i*2; j < MAX; j += i) {
                    primeNumber[j] = false;
                }
            }
        }
    }

    public static void goldBachPartition(int number){

        for (int i = number / 2; i > 0; i--) {
            if(primeNumber[i]){
                if(primeNumber[number-i]){
                    System.out.println(i + " " + (number-i));
                    return;
                }
            }
        }
    }
}
