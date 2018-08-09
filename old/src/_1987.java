

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * ���� 1987 ���ĺ�
 * �������� ����
 * �޸𸮶� �ӵ� ��� �˸�
 */

public class _1987 {

	static int R;
	static int C;
	static int[][] map;
	static boolean[] alpha = new boolean[27];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int ans =0;
	static boolean flag = false;


	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=s.charAt(j)-65;
			}
		}

		dfs();

		System.out.print(ans);

	}

	static void dfs() {

		Stack<Point2> stack = new Stack<>();

		alpha[map[0][0]]=true;
		stack.push(new Point2(0,0,1,alpha));
		

		Point2 p;
		int curX =0;
		int curY =0;
		int nX=0;
		int nY=0;

		while(!stack.isEmpty()) {

			p = stack.peek();
			ans = p.c > ans? p.c : ans;
			curX = p.x;
			curY = p.y;
			
			if(p.c == 26) break;

			flag = false;

			for(int i=0; i<4; i++) {

				if(p.d>=i) continue;

				nX=curX + dx[i];
				nY=curY + dy[i];

				if(nX<0 || nX>=R || nY<0 || nY >=C) continue;
				if( p.alpha[map[nX][nY]] ) continue;

				p.alpha[map[nX][nY]]=true;
				stack.push(new Point2(nX, nY, p.c+1,p.alpha));
				p.d=i;
				p.alpha[map[nX][nY]]=false;

				flag=true;

				break;

			}

			if(!flag) {
				Point2 s = stack.pop();
			}
		}

	}
}

class Point2 {
	int x;
	int y;
	int c;
	int d=-1;
	boolean[] alpha;

	Point2 (int x, int y, int c, boolean v[]){
		this.x = x;
		this.y = y;
		this.c = c;
		this.alpha = Arrays.copyOf(v,27);

	}
}
