package brutforce;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15649 {
    static int n;
    static int m;
    static Deque<Integer> que;
    static boolean[] visited = new boolean[9];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        que = new LinkedList<>();

        dfs();
    }

    public static void dfs(){
        if(que.size() == m){
            for ( int number : que){
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                visited[i] = true;
                que.add(i);
                dfs();
                visited[i] = false;
                que.removeLast();
            }
        }
    }
}
