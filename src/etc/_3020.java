package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3020{
	static int N;
	static int H;
	static int min = 200000;
	static int cunt = 0;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[] s = new int[500001];
		int[] j = new int[500001];
		
		int[] ts = new int[500001];
		int[] tj = new int[500001];
		
		
		int[] h = new int[H+1];
		
		
		for(int i=0; i<N/2; i++) {
			int a = Integer.parseInt(br.readLine());
			
			s[a]++;
			
			int b = Integer.parseInt(br.readLine());
			
			j[H-b+1]++;

		}
		
		for(int i=H; i>0; i--) {
			if(i==H) {
				ts[H]=s[H];
				tj[1]=j[1];
			}else {
				ts[i]=ts[i+1]+s[i];
				tj[H-i+1]=tj[H-i]+j[H-i+1];
			}
			
			h[i]=h[i]+ts[i];
			h[H-i+1]=h[H-i+1]+tj[H-i+1];
		}
		
		for(int i=1; i<=H; i++) {
			
			if(h[i]<min) {
				min = h[i];
				cunt =1;
				
			}else if(h[i]==min) {
				cunt++;
			}
			
			
		}
		
		
		System.out.println(min+" "+cunt);
		
	}
}

