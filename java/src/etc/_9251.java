package etc;

import java.util.*;

// LCS Longest Common Sequence
// dp[i][j] I�� J ���� �ִ� ������ A,B�� �Ҷ�, A[i], B[j]���� ���� �κм����� �ִ밪


public class _9251{
	static int[][] dp = new int[1001][1001];
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		char[] a = sc.nextLine().toCharArray();
		char[] b = sc.nextLine().toCharArray();
		sc.close();
		
		for(int i=1; i<=a.length; i++) {
			for(int j=1; j<=b.length; j++) {
				if(a[i-1]==b[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					// �̺κ��� ���ص��� �ʴ´�.
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);				
				}
			}
		}
		System.out.println(dp[a.length][b.length]);		
	}
}