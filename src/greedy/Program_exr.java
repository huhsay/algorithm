package greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Program_exr {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] array = new int[n+2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < reserve.length; i++) {
            set.add(reserve[i]);
        }


        for (int a : lost) {
            if ( set.contains(a) ){
                set.remove(a);
                answer++;
                continue;
            }
            array[a]++;
        }

        for (int a : set) {

            if(array[a-1] != 0) {
                answer ++;
                array[a-1]--;
                continue;
            }
            if(array[a+1] != 0) {
                answer++;
                array[a+1]--;
            }
        }
        return answer + n - lost.length;
    }

    @Test
    public void test() {
        int n = 7;
        int[] lost = {2,3,4};
        int[] reserve = {1,2,3,6};

        Assert.assertEquals(6, solution(n, lost, reserve));

    }

}
