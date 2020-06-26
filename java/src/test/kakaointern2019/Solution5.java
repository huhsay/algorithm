package test.kakaointern2019;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution5 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        boolean[] visited = new boolean[stones.length];

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(new Pair(i, stones[i]));
        }

        Pair temp;
        while (!priorityQueue.isEmpty()) {
            temp = priorityQueue.poll();

            answer += temp.count - answer;
            visited[temp.index] = true;

            int count = 0;
            int index;
            for (int i = 0; i < k; i++) {
                index = temp.index - i;
                if (index < 0) break;
                if (visited[temp.index - i]) count++;
            }

            if (count == k) return answer;

            count = 0;
            for (int i = 0; i < k; i++) {
                index = temp.index + i;
                if (index >= stones.length) break;
                if (visited[index]) count++;
            }

            if (count == k) return answer;
        }

        return answer;
    }

    @Test
    public void test1() {
        int[] stones = {1, 1, 2, 2, 2, 2, 2, 2, 1, 1};
        int k = 3;

        System.out.println(solution(stones, k));
    }

    class Pair implements Comparable<Pair> {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return this.count - o.count == 0 ? this.index - o.index : this.count - o.count;
        }
    }
}
