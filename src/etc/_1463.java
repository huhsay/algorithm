package etc;

import java.util.Scanner;

public class _1463 {

	static Scanner sc = new Scanner(System.in);
	static int c1 = 0;
	static int c2 = 0;
	static int c3 = 0;

	public static void main(String args[]){
		int ms = sc.nextInt();
		int[][] m = new int[ms][ms];

		for(int i=0; i<ms; i++){
			for(int j=0; j<ms; j++){
				m[i][j] = sc.nextInt();
			}
		}

		divPaper(m, ms);
		System.out.println(c1);
		System.out.println(c2);
		System.out.print(c3);

	}

	static boolean isSame(int[][] a, int b){
		if(b>1){
			for(int i=0; i<b; i++){
				for(int j=0; j<b-1; j++){
					if( a[i][j]==a[i][j+1]);
					else{
						return false;
					}
				}
			}
		}
		return true;
	}

	static void divPaper(int[][] a, int b){

		if(b>0){

			boolean same=isSame(a, b);

			if(same){
				if(a[0][0]==-1){
					c1++;
				}
				else if(a[0][0]==0){
					c2++;
				}
				else{
					c3++;
				}
			}

			else{
				int nm=b/3;
				int[][] n1=new int[nm][nm];
				int[][] n2=new int[nm][nm];
				int[][] n3=new int[nm][nm];
				int[][] n4=new int[nm][nm];
				int[][] n5=new int[nm][nm];
				int[][] n6=new int[nm][nm];
				int[][] n7=new int[nm][nm];
				int[][] n8=new int[nm][nm];
				int[][] n9=new int[nm][nm];

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n1[i][j] = a[i][j];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n2[i][j] = a[i][j+nm];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n3[i][j] = a[i][j+2*nm];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n4[i][j] = a[i+nm][j];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n5[i][j] = a[i+nm][j+nm];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n6[i][j] = a[i+nm][j+2*nm];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n7[i][j] = a[i+2*nm][j];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n8[i][j] = a[i+2*nm][j+nm];
					}
				}

				for(int i=0; i<nm; i++){
					for(int j =0; j<nm; j++){
						n9[i][j] = a[i+2*nm][j+2*nm];
					}
				}								
				divPaper(n1, nm);
				divPaper(n2, nm);
				divPaper(n3, nm);
				divPaper(n4, nm);
				divPaper(n5, nm);
				divPaper(n6, nm);
				divPaper(n7, nm);
				divPaper(n8, nm);
				divPaper(n9, nm);
			}
		}
	}
}