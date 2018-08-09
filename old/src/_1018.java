

import java.io.BufferedReader;

/*
 * 1018 ü����
 * brute force
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018 {
	static int[][] map = new int[51][51];
	static int N;
	static int M;
	static int ans=10000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]= s.charAt(j) == 'W' ? 0 : 1;
			}
		}
		
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				bf(i,j);
			}
		}
		
		System.out.print(ans);
	}
	
	public static void bf(int x, int y) {
		
		int t = map[x][y];
		int t2 = t^1;
		int cnt1=0;
		int cnt2=0;
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(map[i][j]!=t) {
					cnt1++;
				}
				t ^= 1;
				if(map[i][j]!=t2) {
					cnt2++;
				}
				t2 ^=1;
				
				if(cnt1 >=ans && cnt2 >=ans) return;
				
			}
			t ^= 1;
			t2 ^= 1;
		}
		
		ans = Math.min(ans, Math.min(cnt1, cnt2));
		
	}
}
