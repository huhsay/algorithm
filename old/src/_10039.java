import java.util.Scanner;

public class _10039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		
		for(int i = 0; i<5; i++){
			int tem =sc.nextInt();
			if(tem<40){
				sum+=40;
			}
			else{
				sum+=tem;
			}
		}
		System.out.println(sum/5);
	}
}
