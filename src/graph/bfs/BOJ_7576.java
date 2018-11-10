package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int M;
    static int N;
    static int[][] map;

    static int[] dm ={0, 1, 0, -1};
    static int[] dn ={1, 0, -1, -0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1){
                    q.add(new Point(i,j));
                }
            }
        } // input

        int time = -1;

        while(!q.isEmpty()){
            time++;
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                Point current = q.remove();

                for (int j = 0; j < 4; j++) {
                    int nextM = current.m + dm[j];
                    int nextN = current.n + dn[j];
                    if(canNext(nextM, nextN)){
                        q.add(new Point(nextM, nextN));
                        map[nextM][nextN] = 1;
                    }
                }
            }
        }

        if(!isFull()){
            System.out.println(-1);
            return;
        }
        System.out.println(time);
    }

    public static boolean canNext(int m, int n){
        if(m <0 || m >=M || n<0|| n>=N) return false;
        if(map[m][n] == -1 || map[m][n]== 1) return false;
        return true;
    }

    public static boolean isFull(){
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if(map[m][n]==0) return false;
            }
        }

        return true;
    }


    public static class Point{
        int m;
        int n;

        public Point(int x, int y) {
            this.m = x;
            this.n = y;
        }
    }
}
