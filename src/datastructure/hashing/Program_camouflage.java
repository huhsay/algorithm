package datastructure.hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Program_camouflage {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        Iterator<String> iterator = map.keySet().iterator();


        while(iterator.hasNext()) {
            answer *= ( map.get(iterator.next()) + 1 );
        }

        return answer - 1;
    }
}
