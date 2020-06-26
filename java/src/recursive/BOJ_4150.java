package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4150 {
    static BigInteger[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new BigInteger[n+1];
        numbers[1] = new BigInteger("1");
        numbers[2] = new BigInteger("1");
        numbers[0] = new BigInteger("0");

        System.out.println(solve(n));
    }

    public static BigInteger solve(int target){
        if(numbers[target] == null) {
            numbers[target] = solve(target-1).add(solve(target-2));
        }

        return numbers[target];
    }


}
