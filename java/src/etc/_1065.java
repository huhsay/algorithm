package etc;

import java.util.Scanner;

public class _1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		int count=0;
		
		for(int i=1; i<num+1; i++) {
			if(han(i)==true) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static boolean han(int i) {
		if(i<100) {
			return true;
		}
		else if(i==1000){
			return false;
		}
		else {
			int a = i/100;
			int b = i%100/10;
			int c = i%10;
			if(a-b==b-c) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
