package etc;

import java.util.Scanner;

public class BOJ_2775 {

    static int[][] apt = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}};
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(dfs(x, y));
            sc.nextLine();
        }
    }

    public static int dfs(int x, int y){
        if(x == 0) return apt[x][y];
        if(y == 0) return 0;

        return dfs(x, y-1) + dfs(x-1, y);
    }
}
