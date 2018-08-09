

import java.util.Scanner;

/*
 * 에라토스테네스의 체를 이용한 풀이
 * 제곱근을 사용하는 것.
 */

public class _1929 {
	static int[] primNum= new int[1000000];

	static int index=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s=sc.nextInt();
		int e=sc.nextInt();
		sc.close();
		
		for(int i=0; i<1000000; i++)
			primNum[i]=0;
		
		primNum[0]=1;
		primNum[1]=1;
		
		for(int i=2; i*i<=e; i++){
			for(int j=i*2, k=2; j<=e; j=i*(++k))
				primNum[j]=1;
		}
		
		for(int i=s; i<=e; i++){
			if(primNum[i]!=1)
				System.out.println(i);
		}
	}
}
