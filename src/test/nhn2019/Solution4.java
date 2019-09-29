package test.nhn2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution4 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> cards = new HashMap<>();
        String temp;
        for (int i = 0; i < N; i++) {
            temp = st.nextToken();
            if(cards.containsKey(temp)) {
                cards.put(temp, cards.get(temp) + 1);
            } else {
                cards.put(temp, 1);
            }
        }

        boolean isSame = true;
        boolean canSame = true;

        Iterator<String> keys = cards.keySet().iterator();
        String key = keys.next();
        int pre = cards.get(key);
        int current = 0;
        int count = 0;
        int sameCount = 0;
        int min;
        while( keys.hasNext() ) {
            key = keys.next();
            current = cards.get(key);

            if(pre > current){
                isSame = false;
                if( pre - current == 1){
                    count ++;
                    if( count > 1) {
                        canSame = false;
                        break;
                    }
                }else {
                    canSame = false;
                    break;
                }
            }else if ( pre == current ) {
                isSame = true;
                sameCount++;
                continue;
            }else if( pre < current) {
                isSame = false;

                if(sameCount > 0) {
                    canSame = false;
                    break;
                }
                if( current - pre > 1){
                    canSame = false;
                    break;
                }
                pre = current;

            }
        }


        int size = cards.size();

        if(isSame){

            System.out.println("Y");
            System.out.println(N);
            System.out.println(size);
            return;

        }

        if (canSame) {
            System.out.println("Y");
            System.out.println(N+1);
            System.out.println(size);
        } else {
            System.out.println("N");
            System.out.println(N);
            System.out.println(size);
        }

    }
}
