import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/*
 * ���� 2661
 * https://www.acmicpc.net/problem/2661
 * n�� ũ�Ⱑ �ɶ����� �Ź� ���� �����̾�� �Ѵ�.
 * check �Լ��� ������ ������ �˻��ϴ� ����� ���ؼ�...
 */

public class _2661 {

	public static int n=0;
	public static boolean flag=false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();

		dfs("1" , 1);

	}


	static void dfs(String s, int len) {

		if(flag) return;

		if(len==n) {
			
				System.out.print(s);
				flag = true;
			

		}else {
			for(int j=1; j<4; j++) {
			 if(check(s+j))	
				dfs(s+j, len+1);
			}
		}
	}

	public static boolean check(String s) {
		int len = s.length();
		int start = len;
		int end = len-1;
		
		for(int i=1; i<=len/2; i++) {
			
			if(s.substring(end-i, start-i).equals(s.substring(end,start))) {
					return false;
			}
			end--;
		}
		return true;
	}
}
