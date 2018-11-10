package simulation;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1094 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int count = 0;
        int length = 64;
        PriorityQueue<Integer> sticks = new PriorityQueue<>();
        sticks.add(64);

        while(length != x){
            int temp = sticks.poll()/2;
            sticks.add(temp);
            int sum = 0;
            for (int i = 0; i < sticks.size(); i++) {
                sum = sticks.stream().mapToInt(s -> s).sum();
            }
            length = sum;
            if( sum < x){
                sticks.add(temp);
                length +=temp;
            }
        }

        System.out.println(sticks.size());
    }
}
