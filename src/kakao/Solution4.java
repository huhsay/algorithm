package kakao;

import java.util.HashMap;

public class Solution4 {

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int count = 0;

            if(hashMap.containsKey(queries[i])){
                answer[i] = hashMap.get(queries[i]);
                continue;
            }


            for (int j = 0; j < words.length; j++) {
                if(words[j].length() != queries[i].length()) continue;

                if(isMatch(words[j], queries[i])) {
                    count++;
                }
            }

            hashMap.put(queries[i], count);
            answer[i] = count;
        }

        return answer;
    }

    public boolean isMatch(String word, String query){

        for (int i = 0; i < word.length()-query.length()+1; i++) {
            int queryIndex = 0;
            int targetIndex = i;
            char target = word.charAt(targetIndex);
            char queryChar = query.charAt(queryIndex);

            while(queryChar == '?' || target == queryChar){
                if(queryIndex == query.length()) return true;

                target = word.charAt(targetIndex);
                queryChar = query.charAt(queryIndex);

                queryIndex++;
                targetIndex++;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        Solution4 solution4 = new Solution4();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution4.solution(words, queries);

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
