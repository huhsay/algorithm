package test.line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        int sort;
        String temp = st.nextToken();
        switch (temp) {
            case "TOP":
                sort = 1;
                break;
            case "BOTTOM":
                sort = 2;
                break;
            case "MIDDLE":
                sort = 3;
                break;
        }

        for (int i = 0; i < N; i++) {
            
        }
        
    }
    
    static void makeZero(int size){
        int y = 2 * size - 1;
        StringBuilder[] sb = new StringBuilder[size];

        for (int i = 0; i < size; i++) {
            sb[0].append("#");
        }
        sb[0].append(" ");

        for (int i = 1; i < y-1; i++) {
            sb[i].append("#");
            for (int j = 0; j < size-2; j++) {
                sb[i].append(".");
            }
            sb[i].append("#");
            sb[i].append(" ");
        }

        for (int i = 0; i < size; i++) {
            sb[y-1].append("#");
        }
        sb[y-1].append(" ");

        String[] zero = new String[y];

        for (int i = 0; i < y; i++) {
            zero[i] = sb[0].toString();
        }

    }
}
