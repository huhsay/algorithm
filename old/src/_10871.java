import java.util.*;


public class _10871 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int x = sc.nextInt();
		
		int num[] = new int[a];
		for(int i=0; i<a; i++){
			num[i]=sc.nextInt();
		}
		
		sc.close();
		
		for(int i=0; i<a; i++){
			if(num[i]<x){
				System.out.print(num[i]+" ");
			}
		}
	}
}
