package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RamenFactory {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        int index = 0;
        int currentStock = stock;
        PriorityQueue<Supply> queue = new PriorityQueue<>((o1, o2) -> o2.stock - o1.stock);

        int temp;
        while(true) {

            if ( currentStock >= k || index >= dates.length) break;

            temp = dates[index];
            if( currentStock >= temp) {
                queue.add(new Supply(dates[index], supplies[index]));
                index++;
            } else {
                answer++;
                currentStock += queue.poll().stock;
            }

        }

        while( currentStock < k ) {
            currentStock += queue.poll().stock;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        RamenFactory ramenFactory = new RamenFactory();
        System.out.println(ramenFactory.solution(4, dates, supplies, 30));


    }
}

class Supply {
    int date;
    int stock;

    public Supply(int date, int stock) {
        this.date = date;
        this.stock = stock;
    }
}
