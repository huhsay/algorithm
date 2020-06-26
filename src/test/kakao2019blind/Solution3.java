package test.kakao2019blind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    private int answer = 0;

    public int solution(String[][] relation) {

        for (int i = 0; i < relation[0].length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(list, relation);
        }

        return answer;
    }

    private void dfs(ArrayList<Integer> cols, String[][] relation) {
        Set<String> key = new HashSet<>();
        StringBuilder stringBuilder;
        for (int i = 0; i < relation.length; i++) {
            stringBuilder = new StringBuilder();
            for (int a : cols) {
                stringBuilder.append(relation[i][a]).append(" ");
            }

            if (key.contains(stringBuilder.toString())) {
                int a = cols.get(cols.size() - 1);

                for (int j = a+1; j < relation[0].length; j++) {
                    ArrayList<Integer> newCols = new ArrayList<>(cols);
                    newCols.add(j);
                    dfs(newCols, relation);
                }

                return;
            }

            key.add(stringBuilder.toString());
        }

        answer++;
    }

    @Test
    public void test1() {
        String[][] relation = {{"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"2", "3", "3", "3"},
                {"4", "3", "4", "4"},
                {"5", "5", "4", "5"},
                {"6", "6", "6", "5"}};

        String[][] relation2 = {{"a","b","c"},
                {"1","b","c"},
                {"a","b","4"},
                {"a","5","c"}};


        String[][] relation3 = {{"a","aaa","4"},
                {"aa","a","5"},
                {"aaa","2","4"}};

        System.out.println(solution(relation2));
    }
}
