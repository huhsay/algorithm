package test.kakaointern2019;

import org.junit.Test;

import java.util.*;

public class Solution4 {
    public long[] solution(long k, long[] room_number) {
        long[] answers = new long[room_number.length];

        Set<Long> hi = new HashSet<>();
        long target;
        for (int i = 0; i < room_number.length; i++) {
            target = room_number[i];
            while(hi.contains(target)){
                target += 1;
            }
            answers[i] = target;
            hi.add(target);
        }
        return answers;
    }

    @Test
    public void test() {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};

        System.out.println(Arrays.toString(solution(k,room_number)));



        ArrayList<Parent> parents = new ArrayList<>();
        parents.add(new Child1());
        parents.add(new Child2());

    }
    //10	[1,3,4,1,3,1]	[1,3,4,2,5,6]
}
