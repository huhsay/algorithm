package etc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


/*
 * dfs ���� �ε�
 * �����ð��� stack���� Ǯ�
 */
public class _9466 {
	public static int T;
	public static int N;
	public static int ans;
	public static int[] count = new int[100001];
	public static int[] s = new int[100001];

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		Stack<Integer> stk = new Stack<>();
		for(int i=0; i<T; i++) {
			N=sc.nextInt();

			//�迭 �ʱ�ȭ

			for(int j=1; j<=N; j++) {
				s[j]=sc.nextInt();
				count[s[j]]++;
			}

			for(int j=1; j<=N; j++) {
				if(count[j]==0)
					stk.add(j);
			}

			while(!stk.isEmpty()) {
				int k = stk.pop();
				ans++;
				count[s[k]]--;
				if(count[s[k]]==0) {
					stk.add(s[k]);
				}
			}

			System.out.println(ans);

			Arrays.fill(count, 0);
			Arrays.fill(s, 0);
			ans=0;
		}
	}
}
