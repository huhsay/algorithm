package brutforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10448 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Integer> trialNum = new ArrayList<>();

        for (int i = 0; i <50 ; i++) {

            if( i*(i+1)/2 <= 1000){
                trialNum.add( i*(i+1)/2 );
            }
        }

        for(int t = 0; t < T; t++) {
            int num = sc.nextInt();
            boolean f = false;
            H: for (int i = 1; i < trialNum.size(); i++) {
                for (int j = i; j < trialNum.size(); j++) {
                    for (int k = j; k < trialNum.size(); k++) {
                        if(num == trialNum.get(i) + trialNum.get(j) + trialNum.get(k)){
                            f = true;
                            break H;
                        }
                    }
                }
            }

            if(f){
                System.out.println(1);
                continue;
            }
            System.out.println(0);
        }
    }
}
