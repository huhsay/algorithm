package etc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
 * ���� 1405 ��ģ �κ�
 * https://www.acmicpc.net/problem/1405
 * 
 */

public class _1405 {

	public static int n=0;
	public static double d[] = new double[4];
	public static double ans=0;
	public static boolean[][] visited = new boolean[29][29];

	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<4; i++) {
			d[i]=(double)sc.nextInt()/100;
		}

		sc.close();
		
		visited[14][14]=true;
		dfs(14, 14 , 0, 1);
		
		System.out.println(ans);

	}


	static void dfs(int x, int y, int len, double p) {
		if(len == n) {
			ans +=p;
		}else {
			for(int i=0; i<4; i++) {
				
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, ++len, p*d[i]);
					visited[nx][ny] = false;
					--len;
				}
			}
		}
	}

	static boolean check(String s) {

		return false;
	}

}
