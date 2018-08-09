

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * ���� 1987 ���ĺ�
 * ��ͷ� ����
 * ���� : http://mygumi.tistory.com/186
 */

public class _1987_re {
	
	static int R;
	static int C;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int ans =1;
	static int cnt =1;
	
	
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		boolean[] alpha = new boolean[26];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=s.charAt(j)-65;
			}
		}
		
		dfs(map,alpha,0,0);
		
		System.out.print(ans);
		
	}
	
	static void dfs(int[][] map, boolean[] alpha, int x, int y) {
		
		alpha[map[x][y]] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(-1< nx && nx < R && -1<ny && ny < C ) {
				if(!alpha[map[nx][ny]]) {
					ans = ans > ++cnt ? ans : cnt;
					dfs(map, alpha, nx, ny);
				}
			}
		}
		
		--cnt;
		alpha[map[x][y]]=false;
	}
}