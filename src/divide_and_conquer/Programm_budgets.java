package divide_and_conquer;

import java.math.BigInteger;
import java.util.Arrays;

public class Programm_budgets {
    public int solution(int[] budgets, int M) {

        Arrays.sort(budgets);
        int left = 0;
        int right = M;
        int mid = 0;
        long sum = 0 ;

        if ( sumByLimit(budgets, M) < M) {
            return budgets[budgets.length-1];
        }
        while( left <= right) {
            mid = (left + right) / 2;

            sum = sumByLimit(budgets, mid);

            if( sum > M) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }

        return right;
    }

    private int sumByLimit(int[] budgets, int limit){
        int sum = 0;

        for (int a : budgets) {
            if( a > limit ) {
                sum += limit;
            } else {
                sum += a;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        Programm_budgets programm_budgets = new Programm_budgets();
        System.out.println(programm_budgets.solution(budgets, M));
    }

}
