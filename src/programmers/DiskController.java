package programmers;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    public int solution(int[][] jobs) {

        PriorityQueue<Job> job = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.inputTime - o2.inputTime;
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            job.add(new Job(jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Job> controller = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.time - o2.time;
            }
        });

        int currentTime = job.peek().inputTime;
        int waitTime = 0;

        Job temp;

        while (!job.isEmpty()) {
            temp = job.peek();

            if (temp.inputTime <= currentTime) {
                controller.add(temp);
                job.poll();
            } else {
                if (!controller.isEmpty()) {
                    Job temp2 = controller.poll();
                    currentTime += temp2.time;
                    waitTime += currentTime - temp2.inputTime;

                    continue;
                }

                currentTime = temp.inputTime + temp.time;
                waitTime += temp.time;
                job.poll();
            }
        }

        while(!controller.isEmpty()){
            temp = controller.poll();
            currentTime += temp.time;
            waitTime += currentTime - temp.inputTime;
        }

        return waitTime / jobs.length;
    }

    public static void main(String[] args) {
        int[][] test18= {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
        int[][] test19= {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}};
        DiskController diskController = new DiskController();
        System.out.println( diskController.solution(test19) );
    }
}

class Job {
    int inputTime;
    int time;

    public Job(int inputTime, int tie) {
        this.inputTime = inputTime;
        this.time = tie;
    }
}
