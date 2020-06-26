package test.kako2020;

import java.util.*;

public class Solution1 {

    public int[] solution(String[] gems) {


        ArrayList<String> gemsArray = new ArrayList(Arrays.asList(gems));
        int firstIndex = 0;
        int lastIndex = gems.length - 1;

        boolean last = true;
        boolean first = true;

        while(last && first) {
            String temp;
            while(last) {
                temp = gemsArray.remove(gemsArray.size()-1);
                lastIndex--;
                if( lastIndex == firstIndex) break;
                if(!gemsArray.contains(temp)){
                    last = false;
                    gemsArray.add(temp);
                    lastIndex++;
                }
            }

            while(first) {
                temp = gemsArray.remove(0);
                firstIndex++;

                if(!gemsArray.contains(temp)) {
                    first = false;
                    gemsArray.add(0, temp);
                    firstIndex--;
                }
            }
        }

        int[] answerArray = new int[2];
        answerArray[0] = firstIndex + 1;
        answerArray[1] = lastIndex + 1;

        return answerArray;
    }

    public static void main(String[] args) {

        String[] germ = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] germ1 = {"AA", "AB", "AC", "AA", "AC"};
        String[] germ2 = {"XZY", "XYZ", "XYZ"};
        String[] germ3 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.solution(germ3)));
    }
}
