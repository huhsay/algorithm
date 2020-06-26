package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2003 {
    static int N;
    static int M;
    static int[] array;

    static int cunt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum += array[j];
                if(sum == M){
                    cunt++;
                    break;
                }
                if(sum > M){
                    break;
                }
            }
            sum = 0;
        }
        System.out.println(cunt);
    }
}
