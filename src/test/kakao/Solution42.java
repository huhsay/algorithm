package test.kakao;

import java.util.HashMap;

public class Solution42 {

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

        char[] wordArray = word.toCharArray();
        char[] queryArray = query.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {

            if( queryArray[i] == '?') continue;

            if( queryArray[i] != wordArray[i]) return false;
        }

        return true;

    }

    public static void main(String[] args) {

        Solution42 solution4 = new Solution42();
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "test/kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution4.solution(words, queries);

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
