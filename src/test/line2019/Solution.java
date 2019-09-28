package test.line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        int messageSize;
        int consumerSize;
        PriorityQueue<Consumer> consumers = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        messageSize = Integer.parseInt(st.nextToken());
        consumerSize = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < messageSize; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < consumerSize; i++) {
            consumers.add(new Consumer(i, 0));
        }

        Consumer tempConsumer;
        while(!queue.isEmpty()){
            int tempMessage = queue.poll();
            tempConsumer = consumers.poll();
            tempConsumer.addMessage(tempMessage);
            consumers.add(tempConsumer);
        }

        Consumer answer = null;
        while(!consumers.isEmpty()){
            answer = consumers.poll();
        }
        System.out.println(answer.count);
    }
}

class Consumer implements Comparable<Consumer>{
    int number;
    int count;

    public Consumer(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Consumer o) {
        return this.count - o.count <= 0 ? -1 : 1;
    }

    public void addMessage(int message){
        this.count += message;
    }
}
