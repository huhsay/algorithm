package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {

    public static int solve(int l, int p, int v){
        int count = 0;

        count = (v/p)*l;

        int temp = v % p;

        if( temp < l) {
            count += temp;
        }else{
            count += l;
        }
        return count;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 1;
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if( l == 0 && p == 0 && v == 0 ) break;

            System.out.println(String.format("Case %d: %d", index, solve(l,p,v)));
            index++;
        }
    }
}
