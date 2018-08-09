import java.util.Scanner;

/*
 *  switch 문으로 모두 돌려줄 필요없이
 *  a = 97이라는 점을 착안하여 temp(알파벳배열의 인덱스)를 구하여 
 *  
 */

public class _10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int alpha[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		
		char[] sarray = s.toCharArray();
		for(int i = 0; i<sarray.length; i++){
			int temp = sarray[i]-97;
			if(alpha[temp]==-1)
				alpha[temp]=i;
		}
		
		for(int i = 0; i<alpha.length; i++){
			System.out.print(alpha[i]+" ");
		}
	}
}
