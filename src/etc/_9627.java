package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  ���� 9627 ����
 *  https://www.acmicpc.net/problem/9627
 *  
 *  ���ڿ��� �մ String�� �ƴ϶� StringBuilder ����Ѵ�.
 *  StringBuffer�� ����ȭ �����ؼ� ����ϴ� ��!
 * 
 */


public class _9627 {

	static int N;
	static String[] one = {"0","one","two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] ten = {"0","0","twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String[] hun = {"0", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred", "sixhundred", "sevenhundred", "eighthundred", "ninehundred"};
	static StringBuilder[] sN= new StringBuilder[1001]; // ���ڸ� ���ڷ� �ٲ� �� �迭 	
	static String[] s = new String[22]; // �ܾ��
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int index = 0;
		int sum =0;

		for(int i=1; i<=N ; i++) {
			String st = br.readLine();
			
			if(st.equals("$")) {
				index = i;
			}else {
				s[i]=st.trim();
				sum += st.length();
				
			}
		}
		
		for(int i=1; i<1000; i++) {
			
			int temp=sum;
			if(temp+getNum(i)==i) {
				
				s[index]=sN[i].toString();
				break;
				
			}
		}
		
		
		StringBuilder ans=new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			
			if(i==N) {
				ans.append(s[i]);
			}else {
				String temps = s[i]+" ";
				ans.append(temps);
			}
		}
		
		System.out.println(ans.toString());
		
		
		
	}
	
	static public int getNum(int i) {

		int temp =i;
		int sum =0;
		StringBuilder sn = new StringBuilder();
		
		if(temp >= 100) {
			sum+=hun[temp/100].length();
			sn.append( hun[temp/100]) ;
			temp = temp%100;
		}


		if(temp>=10) {

			if(temp/10==1) {
				sum +=one[temp].length();
				sn.append( one[temp] );
				temp = 0;

			}else {
				sum += ten[temp/10].length();
				sn.append(ten[temp/10]);
				temp = temp %10;
			}
		}


		if(temp>0) {
			sum += one[temp].length();
			sn.append(one[temp]);
			
		}

		sN[i] = sn;
		return sum;
	}
}

