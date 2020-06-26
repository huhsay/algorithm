package greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Program_boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int max = people.length - 1;
        for (int i = 0; i < max; i++) {
            if(people[i] + people[max] > limit){
                max--;
                answer += 2;
            } else {
                max--;
                answer += 1;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        int[] people = {30, 50, 80, 50};
        int limt = 100;

        Assert.assertEquals(3, solution(people, limt));
    }
}
