package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 dfs/bfs 단어변환
 */

public class Solution2 {

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        String[] words = {"hot","dot", "dog", "lot", "log", "cog"};
        System.out.println(solution2.solution("hit", "cog", words));
    }

    String[] words;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        visited = new boolean[words.length];
        int[] counts = new int[words.length];
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if( canChange(begin, words[i])){
                queue.add(i);
                visited[i] = true;
                counts[i] = 1;
            }
        }

        while(!queue.isEmpty()) {
            int index = queue.poll();
            String current = words[index];
            int currentCounnt = counts[index];

            if(current.equals(target)){
                answer = counts[index];
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (canChange(current, words[i])) {
                    queue.add(i);
                    visited[i] = true;
                    counts[i] = currentCounnt + 1;
                }
            }
        }

        return answer;
    }
    private boolean canChange(String begin, String target){

        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if( begin.charAt(i) != target.charAt(i)) count++;
        }

        return count == 1;
    }
}
