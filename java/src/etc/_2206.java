package etc;

/*
 * ���� etc._2206 �� �μ��� �̵��ϱ�
 * https://www.acmicpc.net/problem/2206
 * BFS
 * visited 3�������� �����ϱ�
 * bfs visited�� true��� �̹� �湮�� �� ª�� ���� �ֱ� ������ �� �湮 ���� �ʾƵ� ��
 * ������ �ΰ��� ��� ���� �μ����� �ƴѰ�찡 �ֱ⶧���� �ΰ��� ����� �湮���θ� �˾ƾ� �Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _2206 {
	
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

		boolean flage = false;
		int cnt=0;
		visited[1][1][1]=true;
		
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
							queue.add(new Move(nRow, nCol, 0));
							visited[nRow][nCol][0]=true;
							continue;
						}
						else continue;
					}
					
					if(map[nRow][nCol]==0) {
						queue.add(new Move(nRow, nCol, m.item));
						visited[nRow][nCol][m.item]=true;
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
