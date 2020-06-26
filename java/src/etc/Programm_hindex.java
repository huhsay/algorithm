package etc;

import java.util.Arrays;

public class Programm_hindex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int left = 0;
        int right = 1000;

        int mid = 0;
        while( left < right ){
            mid = (int) Math.ceil( (left + right) / 2.0 );

            if(count(mid, citations)) {
                left = mid;
            } else {
                right = mid -1;
            }
        }

        return left;
    }

    private static boolean count(int target, int[] citations) {
        int index = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if(target <= citations[i]) {
                index = i;
                break;
            }
        }

        if( target <= citations.length - index) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] citations= {8,8};
        Programm_hindex programm_hindex = new Programm_hindex();
        System.out.println(programm_hindex.solution2(citations));
    }


    public int solution2(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        int temp = 0;
        for (int i = 0; i < citations.length; i++) {
            temp = Math.min(citations[i], citations.length - i);
            max = Math.max(max, temp);
        }

        return max;

    }
}
