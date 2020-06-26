package test.ncSoft2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution1 {
    public String solution(String s) {

        Stack<Character> number = new Stack<>();
        Stack<Character> string = new Stack<>();

        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);

            switch (temp) {
                case '(':
                    string.add('(');
                    break;
                case ')':
                    int multi = 0;
                    if(!string.isEmpty()){

                        LinkedList<Character> temp2 = new LinkedList<>();
                        char charTemp = string.pop();
                        while(charTemp != '(') {
                            temp2.addFirst(charTemp);
                            charTemp = string.pop();
                        }

                        char numberTemp = string.pop();
                        LinkedList<Character> temp3 = new LinkedList<>();
                        while(numberTemp != '(') {
                            temp3.addFirst(numberTemp);
                            numberTemp = string.pop();
                        }
                        string.add('(');

                        multi = -48;
                        for (int j = 0; j < multi; j++) {
                            string.addAll(temp2);
                        }
                    }

                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    string.add(temp);
                    break;
                default:
                    string.add(temp);

            }
        }

        return toString(string);
    }

    private String toString(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    @Test
    public void test() {
        System.out.println( solution("10(p)") );
    }
}
