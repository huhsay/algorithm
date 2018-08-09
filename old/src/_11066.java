import java.util.*;


/**11066_������ġ�� icpc����
 * ��������� ���� �̿��� ����
 * ���������� �����ϴ� �常 ���Ҽ� �ִٴ� ������ ���µ�
 * ������ Ǯ���� �׷��ٰ� �Ѵ�....
 * �����غô�.
 * bash�� �̿��ؼ�
 * at bash 2**/

public class _11066 {

	static int chap[]= new int[500];
	static int dp[][]= new int[500][500];
	static int sum[][]= new int[500][500];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        int an[]=new int[T];

		for(int i=0; i<T; i++) {
			int t = sc.nextInt();
            
			for(int j=0; j<t; j++) {
				chap[j]=sc.nextInt();
			}
			
			for(int j=0; j<t; j++) {
				sum[j][j]=chap[j];
				for(int k=j+1; k<t; k++) {
					sum[j][k]=sum[j][k-1]+chap[k];
				}
				sum[j][j]=0;
			}
			
			for(int j=0; j<t; j++) {
				dp[j][j]=chap[j];
			}

			for(int diagonal=1; diagonal < t; diagonal++) {
				for(int j=0; j<t-diagonal; j++) {
					int k = j+ diagonal;
						dp[j][k] = min(j,k);
				}
			}
		    an[i]=dp[0][t-1];
		}
		sc.close();
        
        for(int i=0; i<T; i++){
            System.out.println(an[i]);
        }

	}

	static int min(int s, int e) {
		int min=20001;
		for(int j=s; j<e; j++) {
			int temp = dp[s][j]+dp[j+1][e]+sum[s][j]+sum[j+1][e];
			if(temp<min) {
				min=temp;
			}
		}
		return min;
	}
}
