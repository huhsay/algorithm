package etc;

import java.util.Scanner;
// 1����� ����

public class _1780 {
	static int[] n = new int[1000000];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		sc.close();
		
		n[0]=0;
		n[1]=0;
		n[2]=1;
		n[3]=1;

		if(x>3) {
			for(int i=4; i<=x; i++) {
				if(i%3==0) {
					n[i]=Math.min(n[i/3]+1, n[i-1]+1);

				}
				else if(i%2==0){
					n[i]=Math.min(n[i/2]+1, n[i-1]+1);

				}
				else {
					n[i]=n[i-1]+1;
				}
			}
		}

		System.out.println(n[x]);
	}

}
