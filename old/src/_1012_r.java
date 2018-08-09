

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 *  bfs�� Ǯ����. 
 *	��¾�� dfs bfs�� �� ���ϴ�.
 *	ó���� �׷����� �ø� ������ �� ���Ƽ�
 *	�׷��� �׷����� ���� ����
 *	
 *	��� ���ߵ��� ����Ʈ�� ����ְ�
 *	�ϳ��� ���� �湮�� üũ���ְ� �ֺ��� �湮üũ�� �ȵ� ���߰�
 *	�ϳ��� ���� �� cunt�� �÷��־���
 *
 *  �����ؼ� 111 �̶�� ���ð�� ��� �ִ� ���߰� ���� ������ ���´ٸ�
 *  cunt�� �ι�üũ�Ǳ� ������ Ʋ���� �ȴ�.
 *
 */


public class _1012_r {

	static int[][] map = new int[51][51];
	static int T;
	static int M, N, C;
	static int d[][] = { {0,1}, {1,0}, {0,-1},{-1,0} };
	static LinkedList<cabbage> cabbages = new LinkedList<>();
	static Queue<cabbage> q = new LinkedList<>();
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			int y;
			int x;

			for(int i=0; i<C; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				cabbages.add(new cabbage(x,y));
				map[x][y]=1;
			}

			while(!cabbages.isEmpty()) {

				cabbage temp = cabbages.remove();

				if(map[temp.x][temp.y]==0) continue;

				q.add(temp);
				
				boolean flag=false;

				while(!q.isEmpty()) {
					
					cabbage temp2 = q.remove();
					
					if(map[temp2.x][temp2.y]==0) continue;
					
					map[temp2.x][temp2.y]=0; // check visit
					
					int newX;
					int newY;

					for(int i =0; i<4; i++) {

						newX = temp2.x + d[i][0];
						newY = temp2.y + d[i][1];

						if( newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
						
						
						if(map[newX][newY]==1) {
							q.add(new cabbage(newX, newY));
							
						}
					}
					
					flag = true;
				}
				
				if(flag) ans++;


			}
			
			System.out.println(ans);
			
			ans =0;

		}


	}

}

class cabbage{
	int x, y;

	cabbage(int x, int y){
		this.x = x;
		this.y = y;
	}

}
