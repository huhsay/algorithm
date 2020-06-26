package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) throws IOException {

        Stack<Character> stack = new Stack<>();
        List<String> postfixExpression = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infixExpression = br.readLine();

        // to PostFix
        for (int i = 0; i < infixExpression.length(); i++) {
            char temp = infixExpression.charAt(i);

            if (isOperator(temp)) {
                if (temp == '(') {
                    stack.add(temp);
                } else if (temp == '+' || temp == '-') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') break;
                        if (stack.peek() == '*' || stack.peek() == '/') postfixExpression.add(String.valueOf(stack.pop()));
                    }

                    stack.add(temp);
                } else if (temp == '*' || temp == '/') {
                    i++;
                    postfixExpression.add(String.valueOf(infixExpression.charAt(i)));
                    postfixExpression.add(String.valueOf(temp));
                } else if (temp == ')') {
                    while (stack.peek() != '(') {
                        postfixExpression.add(String.valueOf(stack.pop()));
                    }
                    stack.pop(); // (를 빼낸다.
                }
            } else {
                postfixExpression.add(String.valueOf(temp));
            }

        }
        while(!stack.isEmpty()){
            postfixExpression.add(String.valueOf(stack.pop()));
        }

        System.out.println(postfixExpression);


        // calculate

        Stack<Integer> number = new Stack<>();

        for (int i = 0; i < postfixExpression.size(); i++) {

            String temp = postfixExpression.get(i);

            if(temp.equals("+")){
                int oper2 = number.pop();
                int oper1 = number.pop();

                number.add(oper1+oper2);
            }else if(temp.equals("-")){
                int oper2 = number.pop();
                int oper1 = number.pop();

                number.add(oper1-oper2);
            }else if(temp.equals("*")){
                int oper2 = number.pop();
                int oper1 = number.pop();

                number.add(oper1*oper2);
            }else if(temp.equals("/")){
                int oper2 = number.pop();
                int oper1 = number.pop();

                number.add(oper1-oper2);
            }else{
                number.add(Integer.parseInt(temp));
            }
        }

        System.out.println(number.pop());
    }

    public static boolean isOperator(char c) {
        if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*' || c == '/') return true;
        return false;
    }
}
