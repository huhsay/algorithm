package etc;

import java.util.*;

/**
 * ���� 2048 ����
 * 
 */

public class _12100 {


	static int N;
	static int cnt=0;
	static int[][] map;
	static int max=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++){
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		
		sc.close();		
		
		dfs(cnt, map);
		System.out.print(max);
	}
	
	public static void dfs(int cnt, int[][] map) {
		int _cnt = cnt;
		
		if(_cnt<5) {
			dfs(_cnt++, merge(map,1));
			dfs(_cnt++, merge(map,2));
			dfs(_cnt++, merge(map,3));
			dfs(_cnt++, merge(map,4));
		}
	}
	
	public static int[][] copyMap(int[][] map){
		int[][] _map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++){
				_map[i][j] = map[i][j];
			}
		}
		
		return _map;
	}
	
	public static int[][] merge(int[][] map, int d){
		int[][] _map = new int[N][N];
		ArrayList <Integer> linelist;
		
		switch(d) {
		case 1:
			
			for(int row =0; row<N; row++) {
				for(int col=0; col<N; col++) {
					if(map[row][col]==0) continue;
					else {
						for(int i=1; i<N-col-1; i++) {
							if(map[row][col]!=map[row][col+i]) break;
							else {
								map[row][col]=map[row][col]*2;
								map[row][col+i]=0;
							}
						}
					}
				}
			}
			
		case 2:
			
			for(int i=0; i<N; i++) {
				linelist = new ArrayList<Integer>();
				for(int j=N-1; j>=0; j--) {
					if(map[i][j]!=0)
						linelist.add(map[i][j]);
				}
				
				for(int j=0; j<linelist.size()-1; j++) {
					int num1=linelist.get(j);
					
					
//					if(num1==linelist.get(j+1)) {
//						linelist.add(j, num1*2);
//						linelist.remove(j+1);
//						linelist.remove(j+1);
//						max=Math.max(max, num1*2);
//					}
				}
				
				for(int j=linelist.size()-1; j>=0; j++) {
					_map[i][j]=linelist.get(N-j-1);
				}
			}
			break;

		case 3:
			
			for(int i=0; i<N; i++) {
				linelist = new ArrayList<Integer>();
				for(int j=0; j<N; j++) {
					if(map[j][i]==0)
						linelist.add(map[j][i]);
					_map[j][i]=0;
				}
				
				for(int j=0; j<linelist.size()-1; j++) {
					int num1=linelist.get(j);
					if(num1==linelist.get(j+1)) {
						linelist.add(j, num1*2);
						linelist.remove(j+1);
						linelist.remove(j+1);
					}
				}
				
				for(int j=0; j<linelist.size(); j++) {
					_map[j][i]=linelist.get(j);
				}
			}
			break;
			
		case 4:
			for(int i=0; i<N; i++) {
				linelist = new ArrayList<Integer>();
				for(int j=N-1; j>=0; j--) {
					if(map[j][i]!=0)
						linelist.add(map[j][i]);
					_map[j][i]=0;
				}
				
				for(int j=0; j<linelist.size()-1; j++) {
					int num1=linelist.get(j);
					if(num1==linelist.get(j+1)) {
						linelist.add(j, num1*2);
						linelist.remove(j+1);
						linelist.remove(j+1);
						linelist.add(0);
						max=Math.max(max, num1*2);
					}
				}
				
				for(int j=linelist.size()-1; j>=0; j++) {
					_map[j][i]=linelist.get(N-j-1);
				}
			}
			break;
			
		}
		
		return _map;
	}

}
