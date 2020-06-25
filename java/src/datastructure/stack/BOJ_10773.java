package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int temp = 0;
        int sum = 0;

        for (int i = 0; i < K; i++) {
            temp = scanner.nextInt();

            if (temp == 0) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.add(temp);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
