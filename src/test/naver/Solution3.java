package test.naver;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {
    public static void main(String[] args) {

        Solution3 solution3 = new Solution3();
        int[][] data = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
        solution3.solution(data);

    }

    public int[] solution(int[][] data) {
        //int[] answer = {};

        Queue<Request> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        PriorityQueue<Request> wait = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            queue.add(new Request(data[i][0], data[i][1], data[i][2]));
        }

        queue.poll();

        int endTime = 0;
        for (int i = 0; i < data[data.length - 1][1]; i++) {

            if (endTime < i) {
                if (queue.isEmpty()) continue;

                if (queue.peek().time == i) {
                    wait.add(queue.poll());
                }

            } else if (endTime == 1) {

                if (!queue.isEmpty() && queue.peek().time == i) {
                    wait.add(queue.poll());
                }

                if (wait.isEmpty()) continue;

                answer.add(wait.peek().number);
                endTime += wait.poll().page;

            } else {
                if (queue.isEmpty()) continue;

                if (queue.peek().time == i) {
                    if (wait.isEmpty()) {
                        answer.add(queue.peek().number);
                        endTime += queue.poll().page;
                    }
                }
            }
        }

        if(!wait.isEmpty()){
            answer.add(wait.poll().number);
        }


        int[] answerArray = {};
        return answerArray;
    }
}

class Request implements Comparable<Request>{
    int number;
    int time;
    int page;

    public Request(int number, int time, int page) {
        this.number = number;
        this.time = time;
        this.page = page;
    }

    @Override
    public int compareTo(Request o) {
        return this.page >= o.page ? 1 : -1;
    }
}
