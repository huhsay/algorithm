package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2751 {
	
	static int N;
	static int[] a = new int[1000001];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		
		br.close();
		Arrays.sort(a, 0, N);
		
		for(int i=0; i<N; i++) {
			bw.write(a[i]+"\n");
		}
		bw.flush();
		bw.close();
	
	}
}