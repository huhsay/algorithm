import java.util.*;

class _2839{
	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        int count = 0;

	        if(N%5==0) {
	        	count=del(N,0);
	        }
	        else if(N%5==1) {
	        	count=del(N,6);
	        	count=count+2;
	        }
	        else if(N%5==2) {
	        	if(N==7) {
	        		count=-1;
	        	}
	        	else {
	        		count=del(N,12);
	        		count=count+4;
	        	}
	        }
	        else if(N%5==3) {
	        	count=del(N,3);
	        	count=count+1;
	        }
	        else if(N%5==4) {
	        	if(N==4) {
	        		count=-1;
	        	}
	        	else {
	        		count=del(N,9);
	        		count=count+3;
	        	}
	        }
	        else {
	        	count=-1;
	        }
	        
	        System.out.print(count);
	        sc.close();
	}
	
	static int del(int N, int a) {
		int count=0;
		while(N!=a) {
			N=N-5;
			count++;
		}
		return count;
	}
}