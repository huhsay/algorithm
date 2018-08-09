

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * ���� 2309 �ϰ�������
 * https://www.acmicpc.net/problem/2309
 *
 */

public class _2309 {
	
	static ArrayList<Integer> seven;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		
		seven = new ArrayList<>();
		for(int i=0;i<9;i++) {
			seven.add(Integer.parseInt(br.readLine()));
			sum += seven.get(i);
		}
		int goal= sum-100;
		
		Collections.sort(seven);
		
		int temp=0;
		
		SEVEN :
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				temp = seven.get(i)+seven.get(j);
				if(temp==goal) {
					seven.remove(i);
					seven.remove(j-1);
					break SEVEN;
				}
				if(temp>goal) break;
			}
		}
		
	
		for(int i=0; i<7; i++) 
			System.out.println(seven.get(i));
		
	}

}
