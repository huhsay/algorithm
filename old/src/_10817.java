import java.util.*;


public class _10817 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int ar[] = new int[3];
		
		if(a<b){
			ar[0]=a;
			ar[1]=b;
		}
		else{
			ar[0]=b;
			ar[1]=a;
		}
		
		if(c>ar[1]){
			ar[2]=c;
		}
		else if(ar[0]<=c && c<=ar[1]){
			ar[2]=ar[1];
			ar[1]=c;
		}
		else{
			ar[2]=ar[1];
			ar[1]=ar[0];
			ar[0]=c;
		}
		
		System.out.println(ar[1]);
	}
}
