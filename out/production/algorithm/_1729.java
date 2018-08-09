package old;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class _1729 {
	
	final static int EAST =1;
	final static int WEST =2;
	final static int SOUTH =3;
	final static int NORTH =4;
	
	final static int BLANK =0;
	final static int BLOCK =1;
	
	static Point startP;
	
	static int map[][];
	static boolean visited[][][]=new boolean[100][100][5];
	static int cnt=-1;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		map = new int[M][N];
		
		for(int i =0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		startP = new Point(a-1,b-1,c,-1);
		
		int endX=sc.nextInt();
		int endY=sc.nextInt();
		int endD=sc.nextInt();
		
		sc.close();
		
		Queue<Point> q=new LinkedList<Point>();
		
		
//		visited[startP.row][startP.col][startP.dir]=true;
		q.add(startP);
		

		
		while(!q.isEmpty()) {
			cnt++;
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				Point p = q.peek();
				
				visited[p.row][p.col][p.dir]=true;
				
				if(p.row==endX && p.col==endY && p.dir==endD) {
					System.out.println(p.cnt);
					break;
				}
				

				
				if(p.dir==EAST) {
					
					if(p.col+1<N && p.col+1==BLANK && !visited[p.row][p.col+1][p.dir]) {
						q.add(new Point(p.row, p.col+1, p.dir, p.cnt+1));
						
						if(p.col+2<N && p.col+2==BLANK && !visited[p.row][p.col+2][p.dir]) {
							q.add(new Point(p.row, p.col+2, p.dir, p.cnt+1));
							
							if(p.col+3<N && p.col+3==BLANK && !visited[p.row][p.col+3][p.dir]) {
								q.add(new Point(p.row, p.col+3, p.dir, p.cnt+1));
							}
						}
					}else {
						q.add(new Point(p.row, p.col, NORTH, p.cnt+1));
						q.add(new Point(p.row, p.col, SOUTH, p.cnt+1));
					}
				}else if(p.dir==WEST) {
					
					if(p.col-1>=0 && p.col-1==BLANK && !visited[p.row][p.col-1][p.dir]) {
						q.add(new Point(p.row, p.col-1, p.dir, p.cnt+1));
						
						if(p.col-2>=0 && p.col-2==BLANK && !visited[p.row][p.col-2][p.dir]) {
							q.add(new Point(p.row, p.col-2, p.dir, p.cnt+1));
							
							if(p.col-3>=0 && p.col-3==BLANK && !visited[p.row][p.col-3][p.dir]) {
								q.add(new Point(p.row, p.col-3, p.dir, p.cnt+1));
							}
						}
					}else {
						q.add(new Point(p.row, p.col, NORTH, p.cnt+1));
						q.add(new Point(p.row, p.col, SOUTH, p.cnt+1));
					}
				}else if(p.dir==SOUTH) {
					
					if(p.row+1<M && p.row+1==BLANK && !visited[p.row+1][p.col][p.dir]) {
						q.add(new Point(p.row-11, p.col, p.dir, p.cnt+1));
						
						if(p.row+2<M && p.row+2==BLANK && !visited[p.row+2][p.col][p.dir]) {
							q.add(new Point(p.row-2, p.col, p.dir, p.cnt+1));
							
							if(p.row+3<M && p.row+3==BLANK && !visited[p.row+3][p.col][p.dir]) {
								q.add(new Point(p.row, p.col+1, p.dir, p.cnt+1));
							}
						}
					}else {
						q.add(new Point(p.row, p.col, EAST, p.cnt+1));
						q.add(new Point(p.row, p.col, WEST, p.cnt+1));
					}
					
				}else if(p.dir==NORTH) {
					
					if(p.row-1>=0 && p.row-1==BLANK && !visited[p.row-1][p.col][p.dir]) {
						q.add(new Point(p.row-1, p.col, p.dir, p.cnt+1));
						
						if(p.row-1>=0 && p.row-2==BLANK && !visited[p.row-2][p.col][p.dir]) {
							q.add(new Point(p.row-2, p.col, p.dir, p.cnt+1));
							
							if(p.row-1>=0 && p.row+3==BLANK && !visited[p.row+3][p.col][p.dir]) {
								q.add(new Point(p.row-3, p.col, p.dir, p.cnt+1));
							}
						}
					}else {
						q.add(new Point(p.row, p.col, EAST, p.cnt+1));
						q.add(new Point(p.row, p.col, WEST, p.cnt+1));
					}
				}
			}
		}//while
		
		//System.out.println(ans);
	} // main
}

class Point{

	int row, col;
	int dir, cnt;

	Point(int row, int col, int dir, int cnt) {

		this.row = row;
		this.col = col;
		this.dir = dir;
		this.cnt = cnt;
	}
}
