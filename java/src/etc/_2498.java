package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ���� 2498 �߾ӹ��ڿ�
 *  https://www.acmicpc.net/problem/2498
 * 
 */

public class _2498 {
	
	static String A;
	static String B;
	static String C;
	static int[] cunt = new int[4];
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> index = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().trim();
		B = br.readLine().trim();
		C = br.readLine().trim();
		
		
		for(int i=0; i<A.length(); i++) {
			
			if(A.charAt(i)==B.charAt(i) && B.charAt(i)==C.charAt(i)) {
				
				sb.append(A.charAt(i));
				
			}else if(A.charAt(i)==B.charAt(i)) {
				
				sb.append(A.charAt(i));
				cunt[2]++;
				
			}else if(B.charAt(i)==C.charAt(i)) {
				
				sb.append(B.charAt(i));
				cunt[0]++;
				
			}else if(C.charAt(i)==A.charAt(i)) {
				
				sb.append(C.charAt(i));
				cunt[1]++;
				
			}else {
				
				sb.append(A.charAt(i)); // �����Ǽ�
				index.add(i);
				
				cunt[0]++;
				cunt[1]++;
				cunt[2]++;
				
			}
		}
		
		
		while(!index.isEmpty()) {
			
			int i =0;
			int max = 0;
			for(int j=0; j<3; j++) {
				if(cunt[j]>max) {
					max = cunt[j];
					i =j;
				}
			}
			
			cunt[i]--;
			
			int a = index.remove();
			char t='a';
			
			switch(i) {
			case 0:
				t = A.charAt(a);
				break;
			case 1:
				t = B.charAt(a);
				break;
			case 2:
				t = C.charAt(a);
				break;
			}
			
			sb.setCharAt(a, t);
			
			
		}
		
		int max=0;
		int i=0;
		for(int j=0; j<3; j++) {
			if(cunt[j]>max) {
				max = cunt[j];
				i =j;
			}
		}
		
		System.out.println(cunt[i]);
		System.out.println(sb.toString().trim());
		
		
	}
	
}
