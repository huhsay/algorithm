package test.street;

import java.util.Arrays;
import java.util.Stack;

public class Solution1 {
    public int[] solution(int N) {

        int max = 0;
        int maxIndex = 0;
        int multi = 0;
        for (int i = 2; i < 10; i++) {
            multi = getMulti(N, i);

            if (multi >= max) {
                max = multi;
                maxIndex = i;
            }
        }

        int[] answer = {maxIndex, max};
        return answer;
    }

    private Stack<Integer> getNumber(int target, int number) {
        Stack<Integer> stack = new Stack<>();
        while (target != 0) {

            stack.push(target % number);
            target = target / number;
        }

        return stack;
    }

    private int getMulti(int target, int number) {

        Stack<Integer> numbers = getNumber(target, number);
        int answer = 1;
        while (!numbers.isEmpty()) {
            if (numbers.peek() != 0) {
                answer *= numbers.pop();
            } else {
                numbers.pop();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(Arrays.toString(solution.solution(11)));
    }
}
