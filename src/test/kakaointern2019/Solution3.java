package test.kakaointern2019;

import org.junit.Test;

import java.util.*;

public class Solution3 {
    private int targetDef;
    private Set<Set<String>> answers = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        targetDef = banned_id.length - 1;

        List<List<String>> selected = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            selected.add(new ArrayList<>());
        }

        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].length() == banned_id[i].length()) {
                    if (isSame(user_id[j], banned_id[i])) {
                        selected.get(i).add(user_id[j]);
                    }
                }
            }
        }

        dfs(0, new HashSet<String>(), selected);


        return answers.size();
    }

    private void dfs(int def, Set<String> set, List<List<String>> list){
        for (int i = 0; i < list.get(def).size(); i++) {

            Set<String> newSet = new HashSet<>();
            newSet.addAll(set);

            if(newSet.contains(list.get(def).get(i))) continue;
            newSet.add(list.get(def).get(i));

            if( def == targetDef) {
                answers.add(newSet);
            } else {
                dfs(def+1, newSet, list);
            }
        }

    }

    private boolean isSame(String user, String banned) {
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;

            if (banned.charAt(i) != user.charAt(i)) return false;
        }

        return true;
    }

    @Test
    public void test() {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        System.out.println(solution(user_id, banned_id));
    }
}
