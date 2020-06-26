package etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Program_maxnumber {
    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();

    public String solution(int[] numbers) {

        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String string : stringNumbers){
            sb.append(string);
        }

        return sb.toString();
    }
}
