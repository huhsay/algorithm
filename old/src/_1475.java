

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �� ��ȣ 1475
 * https://www.acmicpc.net/problem/1475
 * ���ڿ� 
 */

public class _1475 {
	
	static int[] cunt = new int[10];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		
		
		for(int i =0 ; i<s.length(); i++) {
			int a = Integer.parseInt(s.charAt(i)+"");

			
			if(a==9) {
				
				if(cunt[6]<cunt[9]) {
					cunt[6]++;
				}else {
					cunt[9]++;
				}
				
			}else if(a==6) {
				
				if(cunt[9]<cunt[6]) {
					cunt[9]++;
				}else {
					cunt[6]++;
				}
				
			}else {
				cunt[a]++;
			}
			
		}
		
		Arrays.sort(cunt);
		
		System.out.println(cunt[cunt.length-1]);

		
	}
}
