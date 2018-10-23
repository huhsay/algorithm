package etc;

import java.util.*;

public class _1546 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		double num[] = new double[n];
		double max=0;
		for(int i=0; i<n; i++){
			num[i]=sc.nextDouble();
			if(num[i]>max){
				max=num[i];
			}
		}
		
		sc.close();

		double sum =0;
		for(int i=0; i<n; i++){
				double temp=num[i];
				num[i]=temp/max*100;
				sum+=num[i];
		}

		System.out.printf("%.2f", sum/n);
	}
}
