package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    백준 4949 균형잡힌 세상
    스택
    20190907
 */

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();
        int flag;

        while (!line.equals(".")) {
            flag = 0;
            stack.clear();
            char[] string = line.toCharArray();

            for (char a : string) {
                if (a == '(') {
                    stack.add('(');
                } else if (a == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        flag = 1;
                        break;
                    }
                    if (stack.peek() == '[') {
                        System.out.println("no");
                        flag = 1;
                        break;
                    }
                    stack.pop();
                } else if (a == '[') {
                    stack.add('[');
                } else if (a == ']') {

                    if (stack.isEmpty()) {
                        System.out.println("no");
                        flag = 1;
                        break;
                    }
                    if (stack.peek() == '(') {
                        System.out.println("no");
                        flag = 1;
                        break;
                    }
                    stack.pop();
                }
            }


            line = bufferedReader.readLine();

            if (flag == 1) continue;
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
