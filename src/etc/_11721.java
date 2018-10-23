package etc;

import java.util.*;


public class _11721 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		String st = sc.nextLine();
		sc.close();
		
		int len = st.length();
		for(int i=0; i<len; i=i+10){
			if(i+10<st.length())
				System.out.println(st.substring(i, i+10));
			else
				System.out.println(st.substring(i));
		}
	}
}
