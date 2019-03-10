package etc;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        int max = -40000;
        int min = 40000;
        int sum = 0;
        int bin[] = new int[80002];
        int binMax = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            max = Math.max(max, number);
            min = Math.min(min, number);
            sum += number;
            a[i] = number;
            bin[number+40000]++;
            binMax = Math.max(binMax, bin[number+40000]);
        }

        int temp = 0;
        int ans = 0;
        int count =0;
        for (int i = 1; i <= 80001 ; i++) {

            if(bin[i] == binMax){
                count++;
                ans = i - 40000;
            }
            if(count == 2){
                ans = i -40000;
                break;
            }
        }
        Arrays.sort(a);

        // 산술평균
        System.out.println(Math.round((double)sum/n));

        //중앙값
        System.out.println(a[n/2]);

        //최빈값
        System.out.println(ans);

        //범위
        System.out.println(max-min);
    }
}

class Ex{

    @Test
    void print(){
        System.out.println(-9/5);
        System.out.println(Math.round(-1.8));

    }
}