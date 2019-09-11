package etc;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String[][] answer = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            answer[i][0] = st.nextToken();
            answer[i][1] = st.nextToken();
        }

        Arrays.sort(answer, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(answer[i][0] + " " + answer[i][1] + "\n");

        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
