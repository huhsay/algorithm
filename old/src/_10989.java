import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10989 {
	static int N;
	static int[] array; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array= new int[N];
		
		for(int i=0; i<N; i++) {
			array[i] = (int) Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<N; i++) {
			System.out.println(array[i]);
		}
	}
}
