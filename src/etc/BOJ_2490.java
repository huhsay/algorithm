package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int backCount = 0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    backCount++;
                }
            }

            if (backCount == 0) System.out.println("E");
            if (backCount == 1) System.out.println("A");
            if (backCount == 2) System.out.println("B");
            if (backCount == 3) System.out.println("C");
            if (backCount == 4) System.out.println("D");

        }
    }
}
