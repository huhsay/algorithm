import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        int[][] map = new int[10001][2];
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            Queue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int fork = Integer.parseInt(tokenizer.nextToken());
                int mouth = 0;
                boolean isOld = false;

                while (tokenizer.hasMoreTokens()) {
                    int fork2 = Integer.parseInt(tokenizer.nextToken());

                    if(map[fork][0] != fork2){
                        System.out.println(-1);
                        break;
                    }

                    if(map[fork][1]==1){
                        map[fork][1]=0;
                    }

                    map[fork][0] = fork2;

                    fork = fork2;
                }// while

                map[fork][1] = 1;

            } // for

            StringBuffer sb = new StringBuffer();

            for(int i = 1; i<1001; i++){
                if(map[i][1]==1){
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}