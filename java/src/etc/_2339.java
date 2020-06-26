package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2339 {

	static int[][] map = new int[21][21];
	static int N;
	static int ans;
	static int num;

	static final int verti =1;
	static final int hori =0;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cry=0;
		int inpur=0;
		
		N = Integer.parseInt(br.readLine());

		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					inpur++;
				}
				if(map[i][j]==2) {
					cry++;
				}
			}
		}
		
		if(inpur==0) {
			
			if(cry==1) {
				System.out.println(1);
			}
			else {
				System.out.println(-1);
			}

		}else {
		
		int n1 = divide(0,0,N-1,N-1, hori);
		int n2 = divide(0,0,N-1,N-1, verti);
		
		
		
		if(n1+n2==0) {
			System.out.println(-1);
		}else {
		System.out.println(n1+n2);
		}
		}
	}


	// �߸� ������ �Ǵ��Ѵ�.
	public static int divide(int sx, int sy, int ex, int ey, int dir){
		List<Inpur> inpurList = new ArrayList<>();
		int cry=0;
		int cunt=0;
		
		
		// mpa���� �Ҽ��� ����.
		for(int i = sx; i<= ex; i++) {
			for(int j = sy; j<= ey; j++) {
				if(map[i][j]==1) {
					inpurList.add(new Inpur(i,j));
				}
				if(map[i][j]==2) {
					cry++;
				}
			}
		}

		if(inpurList.isEmpty()) {
			if(cry == 1) return 1;
			
			return 0;

		}else {
			
			for(int i = 0; i<inpurList.size(); i++) {
				Inpur curInpur = inpurList.get(i);
				if(checkCut(sx, sy, ex, ey, curInpur, dir)) {
					
					int num1;
					int num2;
					
					if(dir == hori) {
						num1 = divide(sx, sy, curInpur.x-1, ey, (dir+1)%2);
						num2 = divide(curInpur.x+1, sy, ex, ey, (dir+1)%2);

					}else {
						num1 =divide(sx, sy, ex, curInpur.y-1, (dir+1)%2);
						num2 =divide(sx, curInpur.y+1, ex, ey, (dir+1)%2);
					}
					
					cunt += num1*num2;
					
				}
				
			}
			
			return cunt;
		}


	}

//	���õ� �Ҽ����� ��ġ���� �ڸ���.
//	public static boolean select(int sx, int sy, int etc.ex, int ey, etc.Inpur inpur, int dir) {
//		
//
//		int num1;
//		int num2;
//		
//		if(dir == hori) {
//			num1 = divide(sx, sy, inpur.x-1, ey, dir);
//			num2 = divide(inpur.x+1, sy, etc.ex, ey, dir);
//
//		}else {
//			num1 = divide(sx, sy, etc.ex, inpur.y-1, dir);
//			num2 =divide(sx, inpur.y+1, etc.ex, ey, dir);
//		}
//		
//		if(num1*num2==0) return false;
//		
//		return true;
//		
//		
//	}

	public static boolean checkCut(int sx, int sy, int ex, int ey, Inpur inpur, int dir) {

	    //�ΰ����� �Ȼ����.. (������ �������� �ִ� �Ҽ����� vertical�� �ڸ��� �ȵ�)

		if(dir==hori) {
			if(inpur.x==sx || inpur.x==ex) return false;
			for(int i=sy; i<=ey; i++) {
				if(map[inpur.x][i]==2) return false;

			}
		}
		else {
			//vertical�ΰ��
			
			if(inpur.y==sy ||inpur.y==ey) return false;
			for(int i=sx; i<=ex; i++) {
				if(map[i][inpur.y]==2 ) return false;

			}
		}

		return true;
	}

}

class Inpur{
	int x, y;

	Inpur(int x, int y){
		this.x = x;
		this.y = y;
	}
}