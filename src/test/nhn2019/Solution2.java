package test.nhn2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {
    private static Map<Integer, Integer> queue = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;


        String order;
        int number;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();


            if( order.equals("enqueue")) {
                number = Integer.parseInt(st.nextToken());
                if(queue.containsKey(number)){
                    queue.put(number, queue.get(number)+1);
                }else{
                    queue.put(number, 1);
                }
            }

            if( order.equals("dequeue")) {
                if(queue.isEmpty()){
                    System.out.print("-1 ");
                }

                Iterator<Integer> iterator = queue.keySet().iterator();

                int max = 0;
                int maxNumber = 0;
                while(iterator.hasNext()){
                    int key = iterator.next();
                    int frequency = queue.get(key);
                    if( max < frequency){
                        max = frequency;
                        maxNumber = key;
                    }
                }

                int frequency = queue.get(maxNumber);

                if( frequency == 1){
                    queue.remove(maxNumber);
                } else {
                    queue.put(maxNumber, queue.get(maxNumber) -1 );
                }

                System.out.printf("%d ", maxNumber);
            }

        }
    }
}
