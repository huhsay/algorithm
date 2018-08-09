

import java.util.Scanner;

public class _1978 {
	static int count=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();

		for(int i=0; i<t; i++){
			int temp=sc.nextInt();
			isPrimeNum(temp);
		}

		System.out.println(count);
		sc.close();
	}

	static void isPrimeNum(int i){
		int dividend=2;
		if(i==1)
			return;
		while(i%dividend!=0){
			dividend++;
		}
		if(dividend==i){
			count++;
		}
	}
}
