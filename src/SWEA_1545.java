import java.util.Scanner;

public class SWEA_1545 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuffer br = new StringBuffer();

        for(int i = N; i >= 0; i--){
            br.append(i).append(" ");
        }

        System.out.println(br.toString().trim());
    }
}
