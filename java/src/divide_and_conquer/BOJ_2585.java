package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2585 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> edge = new PriorityQueue<>();

        int x, y;

        edge.add(computeLength(0, 0, 10000, 10000));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            edge.add(Math.min(computeLength(x, y, 0, 0), computeLength(x, y, 10000, 10000)));
        }

        System.out.println( edge.poll() );
    }

    private static int computeLength(int x1, int y1, int x2, int y2) {
        return (int) Math.ceil(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
    }
}
