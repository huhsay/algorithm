import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int m = 20000;

        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());

            if (distance < 4 || distance > 178) {
                break;
            }

            if( distance >= 4 && distance <= 40){
                m = m-720;

                if( m < 0){
                    m = m + 720;
                    break;
                }
            }

            if( distance > 40 ){
                int tempDist = distance- 40;

                int temp = (distance - 40)/8 ;
                if( tempDist%8 != 0){
                    temp++;
                }
                m = m - 720 - (temp*80);

                if( m < 0){
                    m = m+720 + (temp*80);
                    break;
                }
            }

        }// while

        System.out.print(m);
    }
}