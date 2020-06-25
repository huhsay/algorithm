package test.line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> seat = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp;
        for (int i = 1; i <= N; i++) {
            temp = Integer.parseInt(st.nextToken());

            if(temp == 1){
                seat.add(i);
            }
        }

        int max = 0;
        int ans = 0;
        int pre = 0;
        int current;
        int def;

        pre = seat.poll();

        int first = pre - 1;

        while(!seat.isEmpty()) {
            current = seat.poll();
            def = current - pre;

            if(def > max) {
                max = def;
                ans = def / 2;
            }

            pre = current;
        }

        int last = N - pre;

        ans = Math.max( first, Math.max(ans, last));


        System.out.println(ans);
    }
}

