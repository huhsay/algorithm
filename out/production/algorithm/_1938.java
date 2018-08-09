package old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1938 {

	static final int BLANK = 0;
	static final int TREE = 1;
	static final int TARGET = 2;

	static final int[] dRow = {0,-1, 0, 1};
	static final int[] dCol = {-1, 0, 1, 0};

	static final int NONE = 0;
	static final int VERTICAL = 0;
	static final int HORIZON = 1;

	static int N;
	static int[][] map = new int[102][102];
	static boolean[][][] visited =new boolean[52][52][2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());

		Point log = null;
		int bCnt = 0;

		Point target = null;
		int targetCnt = 0;

		for(int i=0; i<N; i++) {

			String s= br.readLine();
			for(int j=0; j < N; j++) {
				char c = s.charAt(j);

				switch(c) {
				case '0':
					map[i][j] = BLANK;
					break;

				case '1':
					map[i][j] = TREE;
					break;

				case 'B':
					map[i][j] = BLANK;
					bCnt++;
					if(bCnt==1) {
						log = new Point(i,j,NONE);
					}else if(bCnt==2) {
						if(log.row==i) {
							log = new Point(i,j, HORIZON);
						}else {
							log = new Point(i,j, VERTICAL);
						}
					}
					break;

				case 'E':
					map[i][j] = TARGET;

					targetCnt++;
					if(targetCnt==1) {
						target = new Point(i,j,NONE);
					}else if(targetCnt ==2) {
						if(target.row==1) {
							target = new Point(i,j,HORIZON);
						}else {
							target = new Point(i,j,VERTICAL);
						}
					}

					break;
				}
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		int step=-1;
		boolean ret =false;

		q.add(log);
		visited[log.row][log.col][log.dir]=true;

		while(!q.isEmpty()&&!ret) {

			step++;

			int size = q.size();
			for(int i=0; i<size; k++) {

				Point n=q.poll();

				if(map[n.row][n.col]==TARGET) {
					if(n.row==target.row && n.col==target.col && n.dir==target.dir) {

						System.out.println(step);
						break;
					}
				}

				for(int j=0; j<4; j++) {

					int nextRow = n.row + dRow[j];
					int nextCol = n.col + dCol[j];

					if(n.dir ==HORIZON) {
						if(nextRow < 0 || nextRow >=N || nextCol-1 < 0 || nextCol +1 >= N) continue;
						if(visited[nextRow][nextCol][n.dir])continue;
						if(map[nextRow][nextCol]==TREE||map[nextRow][nextCol-1]==TREE||map[nextRow][nextCol+1]==TREE) continue;

						q.add(new Point(nextRow, nextCol, n.dir));
						visited[nextRow][nextCol][n.dir]=true;
					}

					if(n.dir == VERTICAL) {

						if(nextRow -1 < 0 || nextRow+1>=N || nextCol<0|| nextCol>=N) continue;
						if(visited[nextRow][nextCol][n.dir])continue;
						if(map[nextRow][nextCol]==TREE || map[nextRow+1][nextCol]==TREE || map[nextRow-1][nextCol]==TREE)continue;

						q.add(new Point(nextRow, nextCol, n.dir));
						visited[nextRow][nextCol][n.dir]=true;
					}
				}

				if(n.row -1 <0 || n.row+1>=N || n.col -1 < 0 || n.col + 1 >= N) continue;
				if(visited[n.row][n.col][n.dir^1]) continue;

				if(int j= n.row-1; j<=n.row+1 && rotateFree; j++) {
					for(int k=n.col-1; k<=n.col+1;k++) {
						if(map[j][k]==TREE) {
							break;
						}
					}
				}
				
				if(rotateFree) {
					
					n.dir^=1;
					q.add(n);
					visited[n.row][n.col][n.dir]=true;
				}
			}
		}
		
		if(!ret) System.out.println(0);
	}
}

class Point{

	int row, col;
	int dir;

	Point(int row, int col, int dir) {

		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}
