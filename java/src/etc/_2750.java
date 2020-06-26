package etc;

import java.util.Scanner;

public class _2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		int[] num = new int[t];
		
		for(int i=0; i<t; i++) {
			num[i]=sc.nextInt();
		}
		
		for(int i=t; i>0; i--) {
			for(int j=0; j<i-1; j++) {
				if (num[j+1]<num[j]) {
						int temp=num[j];
						num[j]=num[j+1];
						num[j+1]=temp;
				}
			}
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(num[i]);
		}
		
		sc.close();
	}
}
