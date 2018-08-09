import java.util.Scanner;

public class _14502 {
	
	public static int N,M,map[][], tempMap[][], virusMap[][];
	public static int[] dx= {-1,1,0,0}, dy ={0,0,-1,1};
	public static int ans=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		tempMap= new int[N][M];
		
		for(int i=0;i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=tempMap[i][j]=sc.nextInt();
			}
		}
		sc.close();
		
		for(int i=0; i<N*M; i++) {
			int row = i/M;
			int col = i%M;
			
			if(tempMap[row][col]==0) {
				tempMap[row][col]=1;
				dfs(i,1);
				tempMap[row][col]=0;
			}
		}
		System.out.println(ans);
	}
	
	public static void dfs(int v, int cnt) {
		int row = v/M;
		int col = v%M;
		
		if(cnt==3) {
			virusMap = new int[N][M];
			for(int i=0; i<N; i++)
				for(int j=0; j<M; j++)
					virusMap[i][j]=tempMap[i][j];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(virusMap[i][j]==2) {
						virus(i,j);
					}
				}
			}
			count();
		}else {
			for(int i=v+1; i<N*M; i++) {
				int nrow=i/M;
				int ncol=i%M;
				
				if(tempMap[nrow][ncol]==0) {
					tempMap[nrow][ncol]=1;
					dfs(i,cnt+1);
				}
			}
		}
		tempMap[row][col]=0;
		--cnt;
	}
	
	public static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			
			if(0<=ny && nx<N && ny<M && 0<=nx) {
				if(virusMap[nx][ny]==0) {
					virusMap[nx][ny]=2;
					virus(nx, ny);
				}
			}
		}
	}
	
	public static void count() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virusMap[i][j]==0) {
					++cnt;
				}
			}
		}
		if(cnt>ans) {
			ans=cnt;
		}
	}
}
