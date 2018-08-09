import java.util.Scanner;

/*
 *  비교연산자 ==은 객체가 같은지를 묻는 거고
 *  String의 값이 같은지를 물을 때는 Strimg.equals()를 사용해야한다.^^*
 */

public class ex {

	public static void main(String[] args) {
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		Scanner sc = new Scanner(System.in);
		String scale = sc.nextLine();
		sc.close();
		
		if(scale.equals(ascending))
			System.out.println("ascending");
		else if(scale.equals(descending))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
