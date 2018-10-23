package brutforce;

import java.util.Scanner;

public class BOJ_3085 {

    static char map[][];
    static int ans = 0;
    static int N = 0;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for (int j = 0; j < N-1; j++) {
                char temp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = temp;
                check();
                temp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = temp;

                temp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp;
                check();
                temp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp;
            }
        }

        System.out.println(ans);
    }

    static void check(){
        for (int i = 0; i < N ; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if(map[i][j]==map[i][j+1]){
                    cnt++;
                }else{
                    ans = Math.max(ans, cnt);
                    cnt = 1;
                }
            }
            ans = Math.max(ans, cnt);
        }

        for (int i = 0; i < N ; i++) {
            int cnt = 1;
            for (int j = 0; j < N-1; j++) {
                if(map[j][i]==map[j+1][i]){
                    cnt++;
                }else{
                    ans = Math.max(ans, cnt);
                    cnt = 1;
                }
            }
            ans = Math.max(ans, cnt);
        }
    }
}
