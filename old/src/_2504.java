import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _2504 {

	static String s;
	static Stack<String> stack = new Stack<>(); 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] array=br.readLine().split("");

		for(int i=0; i<array.length; i++) {
			if(array.equals("(") || array.equals("[")) {
				stack.push(array[i]);
			}else {
				if(array[i].equals(")")) {
					if(stack.peek().equals("(")) {
						
					}
				}
			}
		}
	}

}
