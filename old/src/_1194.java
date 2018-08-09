

/*
 * ���� 1194 ���� ��������, ����
 * https://www.acmicpc.net/problem/1194
 * 
 * ���� �ڷ�
 * http://stack07142.tistory.com/169
 * 
 * ��Ʈ����ũ�� �̿��Ͽ�
 * �ش� ��ġ�� ���踦 ������ �����Ͽ� visited�� �����ϴ� ���� ����Ʈ
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194 {
	
	static final int BLANK=0;
	static final int WALL=-1;
	static final int EXIT =-2;
	
	static final int dRow[]= {0,-1,0,1};
	static final int dCol[]= {-1,0,1,0};
	static final int LEFT =0;
	static final int UP=1;
	static final int RIGHT=2;
	static final int DOWN=3;
	
	static final int a=1;
	static final int A=10;
	static final int f=6;
	static final int F=60;
	
	static int N, M;
	static int[][] map= new int[51][51];
	static boolean[][][] visited= new boolean[51][51][(1<<7)];
	
	public static void main(String ars[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int startRow = -1, startCol=-1;
				
		//init map
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c=s.charAt(j);
				
				switch(c) {
				case '.':
					map[i][j]=BLANK;
					break;
					
				case '#':
					map[i][j]=WALL;
					break;
					
				case '1':
					map[i][j]=EXIT;
					break;
					
				case '0':
					map[i][j]=BLANK;
					startRow=i;
					startCol=j;
					break;
					
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
					map[i][j]=(c-'a'+1);
					break;
					
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
					map[i][j]=(c-'A'+1)*10;
					break;
					
				}
			}
		}
		
		Queue<Min> q=new LinkedList<Min>();
		q.add(new Min(startRow,startCol,0));

		int cnt=-1;
		boolean flag=false;
		
		//game start!
		while(!q.isEmpty()&&!flag) {
			int s=q.size();
			cnt++;
			for(int i=0; i<s; i++) {
				
				Min p = q.poll();
				
				if(map[p.row][p.col]>=a && map[p.row][p.col]<=f) {
					p.key |= 1<<map[p.row][p.col];
				}
				
				//���谡 ���� ���·� ���� �������� ��.
				if(map[p.row][p.col]>=A && map[p.row][p.col]<=F){
					if((p.key &(1<<(map[p.row][p.col]/10)))==0) {
						visited[p.row][p.col][p.key]=true;
						continue;
					}
				}
				
				if(map[p.row][p.col]==EXIT) {
					System.out.println(cnt);
					flag=true;
					break;
				}
				
				for(int j=0; j<4; j++) {
					int nRow=p.row+dRow[j];
					int nCol=p.col+dCol[j];
					
					if(nRow<0 || nRow>=N || nCol<0 || nCol>=M) continue;
					if(visited[nRow][nCol][p.key]) continue;
					if(map[nRow][nCol]==WALL) continue;
					
					q.add(new Min(nRow, nCol, p.key));
					visited[nRow][nCol][p.key]=true;
				}
			}//for
		}//while
		
		if(!flag) System.out.println(-1);

	}
}

class Min {
	int row, col;
	int key;
	
	Min(int row, int col, int key){
		this.row=row;
		this.col=col;
		this.key=key;
	}
}
