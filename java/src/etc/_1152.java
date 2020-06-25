package etc;


import java.util.Scanner;

public class _1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		sc.close();
		int count = 1;
        
        if(input.length()==0)
            count=0;
		
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i)==' ')
				count++;			
		}
		
		System.out.print(count);
		
	}
}
