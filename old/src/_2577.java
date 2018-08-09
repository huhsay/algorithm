import java.util.Scanner;

public class _2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		sc.close();
		int num[] = new int[10];
		
		int sum=a*b*c;
		String n= Integer.toString(sum);
		
		for(int i=0; i<n.length(); i++){
			if (n.charAt(i)=='0')
				num[0]++;
			else if (n.charAt(i)=='1')
				num[1]++;
			else if (n.charAt(i)=='2')
				num[2]++;
			else if (n.charAt(i)=='3')
				num[3]++;
			else if (n.charAt(i)=='4')
				num[4]++;
			else if (n.charAt(i)=='5')
				num[5]++;
			else if (n.charAt(i)=='6')
				num[6]++;
			else if (n.charAt(i)=='7')
				num[7]++;
			else if (n.charAt(i)=='8')
				num[8]++;
			else
				num[9]++;
		}
		
		for(int i=0; i<10; i++){
			System.out.println(num[i]);
		}	
	}
}
