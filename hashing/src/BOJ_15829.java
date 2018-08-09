import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_15829 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger total = BigInteger.ZERO;
        BigInteger r = BigInteger.ONE;

        for(int i = 0; i < L; i++){
            total = total.add(r.multiply(BigInteger.valueOf((long)Character.valueOf(str.charAt(i))-96)));
            r = r.multiply(BigInteger.valueOf(31));
        }

        System.out.println(total.mod(BigInteger.valueOf((long)1234567891)));
    }
}
