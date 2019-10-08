package divide_and_conquer;

public class Programm_immigration {

    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) n * 1000000000;
        long mid;

        while ( left < right ) {
            mid = (left + right) / 2;

            if ( solve( times, mid) > n) {
                right = mid;}
            else{
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private long solve(int[] times, long time) {
        long answer = 0;

        for(int a : times) {
            answer += time / a;
        }

        return  answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] times = {1, 1, 10};
        Programm_immigration programm_immigration = new Programm_immigration();
        System.out.println(programm_immigration.solution(n, times));
    }

}
