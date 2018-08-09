package old;

import java.util.Scanner;


public class Main {
	static int sum =0;
	static int min =10000;
    static boolean flag=false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s=sc.nextInt();
		int e=sc.nextInt();
		sc.close();
		
		for(int i=s; i<=e; i++){
			isPrimeNum(i);
		}
		
        if(flag==false)
            System.out.println(-1);
        else{        
		System.out.println(sum);
		System.out.println(min);
        }
	}

	static void isPrimeNum(int i){
		int dividend=2;
		if(i==1)
			return;
		while(i%dividend!=0){
			dividend++;
		}
		if(dividend==i){
			sum+=i;
			if(i<min)
				min=i;
            flag=true;
		}
	}
}
