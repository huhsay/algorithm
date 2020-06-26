package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[n+2];
        cards[0] = -10000001;
        cards[n+1] = 100000001;
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] targets = new int[m];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer= new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = solve(cards, targets[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(answer[i]).append( " ");
        }
        System.out.println(sb.toString());
    }

    private static int solve(int[] cards, int target){
        if( maxIndex(cards,target) == 0 || minIndex(cards, target) == 0) return 0;

        return maxIndex(cards, target) - minIndex(cards, target) + 1;
    }

    private static int maxIndex(int[] cards, int target){
        int l = 0;
        int r = cards.length -1;
        int mid = 0;

        while( l < r ){

            mid = (int) Math.ceil( (l + r) / 2.0);

            if( target < cards[mid]) {
                r = mid - 1 ;
            } else {
                l = mid;
            }
        }

        return cards[l] == target ? l : 0;
    }

    private static int minIndex(int[] cards, int target){
        int l = 0;
        int r = cards.length-1;
        int mid = 0;

        while( l < r ){

            mid = ( l + r ) / 2 ;

            if( target > cards[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        return cards[l] == target ? l : 0;

    }
}
