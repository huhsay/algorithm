

import java.util.Scanner;

public class _1992 {
	static char[][] map = new char[64][64];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for(int i=0; i<n; i++) {
			map[i]= sc.next().toCharArray();
		}

		div(map, n);
		
		sc.close();

	}

	static void div(char[][] a, int b) {
		if(same(a,b)) {
			System.out.print(a[0][0]);
		}
		else {
			int ns=b/2;
			char[][] ul= new char[ns][ns];
			char[][] ur= new char[ns][ns];
			char[][] nl= new char[ns][ns];
			char[][] nr= new char[ns][ns];

			for(int i=0; i<ns; i++) {
				for(int j =0; j<ns; j++) {
					ul[i][j]=a[i][j];
				}
			}

			for(int i=0; i<ns; i++) {
				for(int j =0; j<ns; j++) {
					ur[i][j]=a[i][j+ns];
				}
			}

			for(int i=0; i<ns; i++) {
				for(int j =0; j<ns; j++) {
					nl[i][j]=a[i+ns][j];
				}
			}

			for(int i=0; i<ns; i++) {
				for(int j =0; j<ns; j++) {
					nr[i][j]=a[i+ns][j+ns];
				}
			}

			System.out.print("(");
			div(ul, ns);
			div(ur, ns);
			div(nl, ns);
			div(nr, ns);
			System.out.print(")");
		}
	}

	static boolean same(char[][] a, int b) {

		if(b>1) {
			for(int i=0; i<b; i++) {
				for(int j=0; j<b; j++) {
					if(a[0][0]!=a[i][j]) {
						return false;
					}
				}
			}
			return true;
		}
		else {
			return true;
		}
	}
}
