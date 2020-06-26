package test.kakao2019blind;

import org.junit.Test;

import java.util.PriorityQueue;

public class Solution4 {
    public int solution(int[] food_times, long k) {
        long answer = 0;
        int count = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int a : food_times) {
            priorityQueue.add(a);
        }

        long current = 0;

        while (answer <= k) {
            if (priorityQueue.isEmpty()) {
                return -1;
            }

            current = priorityQueue.peek() - count;

            if (current == 0) {
                priorityQueue.poll();
                continue;
            }

            answer += current * priorityQueue.size();
            count += current;
            priorityQueue.poll();
        }

        answer -= current * (priorityQueue.size() + 1);
        count -= current;

        int mok = (int) (k - answer) % (priorityQueue.size() + 1);

        int answerInedx = 0;

        for (int i = 0; i < food_times.length; i++) {
            if(food_times[i] - count <= 0) continue;

            mok--;
            if(mok < 0) {
                answerInedx = i+2;
                break;
            }
        }

        return answerInedx;
    }

    @Test
    public void solveIndex() {
        int[] food_times = {3, 1, 2};
        int k = 5;

        System.out.println(solution(food_times, k));
    }
}
