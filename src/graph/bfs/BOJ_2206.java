package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    백준 2206 벽 부수고 이동하기
    최단거리 찾을 때 bfs
    tip
    이미 지나간 자리를 다시가는 경우는 최단 거리가 아니기 때문에
    다음 방문 지점을 넣을 때 빼는 것이 시간 초과를 줄 일 수 있다.
    방문체크는 큐에 넣을 때 하는 게 좋다.
 */

public class BOJ_2206 {
    static int N;
    static int M;
    static int[][] map = new int[1001][1001];
    static boolean[][][] visited = new boolean[1001][1001][2];

    static int[] dRow= {0, 1, 0, -1};
    static int[] dCol= {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //init map
        for(int i=1; i<=N; i++) {
            s=br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j]=Integer.parseInt(s.charAt(j-1)+"");
            }
        }

        Queue<Move> queue = new LinkedList<Move>();
        queue.add(new Move(1,1,1));
        visited[1][1][1] = true;

        boolean flage = false;
        int cnt=0;

        GAME:
        while(!queue.isEmpty() && !flage ) {

            cnt++;
            int size = queue.size();
            for(int i=0; i<size; i++) {

                Move m=queue.poll();

                for(int j=0; j<4; j++) {
                    int nRow=m.x+dRow[j];
                    int nCol=m.y+dCol[j];

                    if(nRow==N && nCol==M) {
                        System.out.println(++cnt);
                        flage = true;
                        break GAME;
                    }

                    if(nRow<1 || nRow>N || nCol<1 || nCol>M || visited[nRow][nCol][m.item]) continue;

                    if(map[nRow][nCol]==1) {
                        if(m.item==1) {
                            if(visited[nRow][nCol][0]) continue;
                            queue.add(new Move(nRow, nCol, 0));
                            visited[nRow][nCol][0] = true;
                            continue;
                        }
                        else continue;
                    }

                    if(map[nRow][nCol]==0) {
                        if( visited[nRow][nCol][1] ) continue;
                        queue.add(new Move(nRow, nCol, m.item));
                        visited[nRow][nCol][m.item] = true;
                    }
                }
            }
        } // while

        if(!flage) System.out.println(-1);
    }
}

class Move{
    int x;
    int y;
    int item=1;

    Move(int x, int y, int item){
        this.x=x;
        this.y=y;
        this.item=item;
    }
}
