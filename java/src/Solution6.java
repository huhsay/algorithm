import org.junit.Test;

import java.util.*;

public class Solution6 {
    public String[] solution(String[][] dataSource, String[] tags){
        String[] answer = new String[1];

        HashMap<String, HashSet<String>> map = new HashMap<>();

        for (int i = 0; i < dataSource.length; i++) {
            String[] tag = dataSource[i];

            String book = tag[0];
            for (int j = 1; j < tag.length; j++) {
                HashSet<String> temp = map.get(tag[j]);

                if (temp != null){
                    temp.add(book);
                    map.put(tag[j], temp);
                } else {
                    HashSet<String> newBook = new HashSet<>();
                    newBook.add(book);
                    map.put(tag[j], newBook);
                }


            }
        }

        HashMap<String, Integer> books = new HashMap<>();

        for (int i = 0; i < tags.length; i++) {
            String tempTag = tags[i];

            HashSet<String> book = map.get(tempTag);

            book.stream().forEach(s -> {
                if(books.get(s)!=null){
                    int temp =books.get(s);
                    temp++;
                    books.put(s, temp);
                } else {
                    books.put(s, 1);
                }
            });
        }

        List<Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });

        // 순서유지를 위해 LinkedHashMap을 사용
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);

        return answer;
    }

    @Test
    public void test() {
        String[][] dataSource = {
                {"doc1", "t1", "t2", "t3"},
                {"doc2", "t0", "t2", "t3"},
                {"doc3", "t1", "t6", "t7"},
                {"doc4", "t1", "t2", "t4"},
                {"doc5", "t6", "t100", "t8"}
        };
        String[] tags = {"t1", "t2", "t3"};
        Solution6 solution6 = new Solution6();
        solution6.solution(dataSource, tags);


    }

}
