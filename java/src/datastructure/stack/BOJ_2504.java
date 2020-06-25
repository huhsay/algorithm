package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 다양한 예외에 대해서 고민하자
 * 스택을 사용할 때 주의해야할 점은
 * pop 메소드를 사용할 경우
 * stack이 비어있지 않아야 한다는 것이다.
 */
public class BOJ_2504 {

    static char[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = br.readLine().toCharArray();


        Stack<String> stack = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            char string = array[i];

            switch (string) {
                case '(':
                    stack.push("(");
                    break;

                case ')':
                    int sum = 0;
                    while (true) {
                        if(stack.empty()){ flag =true; break;}
                        String temp = stack.pop();
                        if (temp == "[" || temp == "]" || temp == ")") {
                            flag = true;
                            break;
                        } else if (temp != "("){
                            sum += Integer.parseInt(temp);
                        } else {
                            if (sum == 0) {
                                stack.push(Integer.toString(2));
                            } else {

                                stack.push(Integer.toString(2 * sum));
                            }
                            break;
                        }
                    }
                    break;

                case '[':
                    stack.push("[");
                    break;

                case ']':
                    int sum2 = 0;
                    while (true) {
                        if(stack.empty()){ flag =true; break;}
                        String temp2 = stack.pop();
                        if (temp2 == "(" || temp2 == ")" || temp2 == "]") {
                            flag = true;
                            break;
                        }  else if (temp2 != "[") {
                            sum2 += Integer.parseInt(temp2);
                        }else {
                            if (sum2 == 0) {
                                stack.push(Integer.toString(3));
                            } else {
                                stack.push(Integer.toString(sum2 * 3));
                            }
                            break;
                        }
                    }
            }
        }

        if(flag==true){
            System.out.println(0);
            return;
        }

        int sum = 0;
        while (!stack.empty()) {
            String temp = stack.pop();
            if (temp == "(" || temp == ")" || temp == "]" || temp == "]") {
                System.out.println(0);
                return;
            }

            sum += Integer.parseInt(temp);
        }

        System.out.println(sum);
    }
}

