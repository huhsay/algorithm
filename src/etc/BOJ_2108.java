package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0;
        int max = 1;
        int count = 1;
        int ans=a[0];
        for (int i = 1; i < n; i++) {
            if(a[i-1] != a[i]){
                if(max == count){
                    temp ++;
                    if(temp == 1){
                        ans = a[i-1];
                    }
                }
                if(max < count){
                    ans = a[i];
                    max = count;
                }
                count = 1;
                continue;
            }
            count++;
        }
        Arrays.sort(a);

        // 산술평균
        System.out.println(Math.round((double)Arrays.stream(a).sum()/n));
        //중앙값
        System.out.println(a[(a.length-1)/2]);

        //최빈값
        System.out.println(ans);

        //범위
        System.out.println(a[a.length-1]-a[0]);
    }
}
