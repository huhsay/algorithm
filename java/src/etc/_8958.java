package etc;

import java.util.Scanner;

// ox 채점하기
// nextInt개행문자를입력받지않음

public class _8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		int an[]=new int[T];
		int score[] = new int[81];
		
		for(int i=0; i<T; i++){
			String temp = sc.nextLine();
			int sum=0;
			
			for(int j=0; j<temp.length(); j++){
				if(temp.charAt(j)=='O'){
					if(j==0)
						score[j]=1;
					else
						score[j]=score[j-1]+1;
				}
				else
					score[j]=0;

				sum=sum+score[j];
			}
			
			an[i]=sum;
		}
		sc.close();
		
		for(int j=0; j<T; j++){
			System.out.println(an[j]);
		}
	}
}
