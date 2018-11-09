package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        char [] integerArray = temp.toCharArray();
        Arrays.sort(integerArray);

        for (int i = integerArray.length-1; i >= 0 ; i--) {
            System.out.print(integerArray[i]);
        }


    }
}
