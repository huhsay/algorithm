package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _3190 {

	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	static final int UP = 4;
	
	static final int[] dx= {0, 0, 1, 0, -1};
	static final int[] dy= {0, 1, 0, -1, 0};
	
	static int[][] map = new int[101][101];
	static String[][] dmap = new String[1000][2];
	
	static int N;
	static int K;
	static int G;
	static int cnt=0;
	static boolean flag=true;
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		// ��� ��ġ
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int aRow = Integer.parseInt(st.nextToken());
			int aCol = Integer.parseInt(st.nextToken());
			
			map[aRow][aCol]=1;
		}
		
		// ���� �ʱ�ȭ
		map[1][1]=2;
		
		LinkedList<Point> snake = new LinkedList<Point>();
		snake.add(new Point(1,1,RIGHT));
		
		G=Integer.parseInt(br.readLine());
		for(int i=0; i<G; i++) {
			st = new StringTokenizer(br.readLine());
			dmap[i][0] = st.nextToken();
			dmap[i][1] = st.nextToken();
		}
		
		int hd=1;
		int t=0;
		int temp=0;
		
		GAME:
			while(flag) {
				if(t<G) {
					int q=Integer.parseInt(dmap[t][0]);
					int x=q-temp;
					temp=q;

					for(int j=0; j<x; j++) {
						cnt++;
						Point head=snake.peek();
						int nx=head.row+dx[head.dir];
						int ny=head.col+dy[head.dir];
						switch(check(nx, ny)) {
							case -1:
								flag=false;
								break GAME;
							case 0:
								snake.addFirst(new Point(nx, ny, hd));
								map[nx][ny]=2;
								Point tail=snake.removeLast();
								map[tail.row][tail.col]=0;
								break;
							case 1:
								snake.addFirst(new Point(nx, ny, hd));
								map[nx][ny]=2;
								break;
							case 2:
								flag=false;
								break GAME;
						}
					}// for
					
					String dir = dmap[t][1];
					if(dir.equals("L")) {
						switch(snake.get(0).dir) {
						case 1:
							hd=4;
							break;
						case 2:
							hd=1;
							break;
						case 3:
							hd=2;
							break;
						case 4:
							hd=3;
							break;
						}
					}else {
						switch(hd) {
						case RIGHT:
							hd=DOWN;
							break;
						case DOWN:
							hd=LEFT;
							break;
						case LEFT:
							hd=UP;
							break;
						case UP:
							hd=RIGHT;
							break;
						}
					}
					
					t++;
					snake.get(0).dir=hd;
					
				} // if
				
				else {
					
					cnt++;
					Point head=snake.peek();
					int nx=head.row+dx[head.dir];
					int ny=head.col+dy[head.dir];
					switch(check(nx, ny)) {
						case -1:
							flag=false;
							break GAME;
						case 0:
							snake.addFirst(new Point(nx, ny, hd));
							map[nx][ny]=2;
							Point tail=snake.removeLast();
							map[tail.row][tail.col]=0;
							break;
						case 1:
							snake.addFirst(new Point(nx, ny, hd));
							map[nx][ny]=2;
						case 2:
							flag=false;
							break GAME;
					}
					
				}
			}//while
		System.out.println(cnt);
	}
	
	static int check(int x, int y) {

		if(x<1 || x>N  || y<1 || y>N)
			return -1;
		else if(map[x][y]==0)
			return 0;
		else if(map[x][y]==1)
			return 1;
		else return 2;
	}
	
}

class Point {

	int row, col;
	int dir;

	Point(int row, int col, int dir) {

		this.row = row;
		this.col = col;
		this.dir = dir;
	}
}

