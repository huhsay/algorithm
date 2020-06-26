package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int R, C;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);

        System.out.println(solve2(R,C,size));

    }

    private static void solve(int r, int c, int size) {
        int resize;
        if( size == 2) {
            count++;
            if( r == R && c == C) {
                System.out.println(count);
                return;
            }

            count++;
            if( r == R && c+1 == C) {
                System.out.println(count);
                return;
            }

            count++;
            if( r+1 == R && c == C) {
                System.out.println(count);
                return;
            }

            count++;
            if( r+1 == R && c+1 == C) {
                System.out.println(count);
                return;
            }

        } else {
            resize = size/2;
            solve(r,c, resize);
            solve(r, c+resize, resize);
            solve(r+resize, c, resize);
            solve(r+resize, c+resize, resize);
        }
    }

    private static int solve2(int r, int c, int n) {

        int x = 0;
        int y = 0;
        int count = 0;

        while( n > 0) {

            n /= 2;

            if( r < y + n && c < x + n) {

                count += n * n * 0;

            } else if ( r < y + n && c >= x + n ) {

                count += n * n * 1;
                x += n;

            } else if ( r >= y + n && c < x + n) {
                count += n*n*2;

                y += n;

            } else {
                count += n*n*3;
                x += n;
                y += n;
            }
        }

        return count;
    }
}
