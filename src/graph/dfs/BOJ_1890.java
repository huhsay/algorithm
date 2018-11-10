package graph.dfs;

import java.util.Scanner;

/**
 * 백준 점프
 * 기본적으로 dfs 풀면 되지만, 시간초과가 난다.
 * 이미 지난간 길에 대한 값을 저장하는 dp를 사용하자
 */

public class BOJ_1890 {
    static int[][] map = new int[100][100];
    static long[][] visited = new long[100][100];
    static int n;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = -1;
            }
            sc.nextLine();
        } //input

        System.out.println(dfs(0, 0));

    }

    static long dfs(int x, int y){

        int temp = map[x][y];

        if(visited[x][y]!=-1){
            return visited[x][y];
        }

        if(x == n-1 && y == n-1) {
            return 1;
        }

        if(temp == 0){
            visited[x][y] = 0;
            return 0;
        }

        long rCount=0;
        long dCount=0;
        if(y+temp < n){
            rCount = dfs(x, y+temp);
        }
        if(x+temp < n){
            dCount = dfs(x+temp, y);
        }

        visited[x][y] = rCount + dCount;
        return rCount + dCount;
    }

}
