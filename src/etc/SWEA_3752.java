package etc;

import java.util.Scanner;

public class SWEA_3752 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean[] ans;


        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int cunt=1;
            ans = new boolean[10001];

            for(int j = 0; j < N; j++){
                int number = sc.nextInt();
                int temp = ans.length;

                for(int k=temp-1; k>=0; k--){
                    if(ans[k] && k+number<10001){
                        if(!ans[k+number]) {
                            ans[k+number]=true;
                            cunt++;
                        }
                    }
                }

                if(!ans[number]){
                    ans[number]=true;
                    cunt++;
                }
            }

            System.out.println("#"+i+" "+cunt);
            ans=null;

        }
    }
}
