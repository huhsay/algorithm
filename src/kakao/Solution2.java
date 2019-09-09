package kakao;

import javafx.beans.binding.StringBinding;

import java.util.Stack;

public class Solution2 {
    public String solution(String p) {

        if( isRight(p) ){
            return  p;
        } else {
            return toRight(p);
        }
    }

    public boolean isRight(String p) {
        char[] chars = p.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char a : chars){
            if(a == '('){
                stack.push('(');
            } else if ( a == ')'){
                if( stack.isEmpty() ){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBalanced(String p){
        int left = 0;
        int right = 0;
        for (char a : p.toCharArray()){
            if(a == '('){
                left++;
            } else {
                right++;
            }
        }
        return  left == right;
    }

    public String toRight(String p) {
        if( p.length() == 0 ) return p;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= p.length(); i++) {

            String u = p.substring(0,i);
            String v = p.substring(i, p.length());

            if(isBalanced(u)){
                if(isRight(u)){
                    return u + toRight(v);
                }else {
                    sb.append('(');

                    sb.append(toRight(v));
                    sb.append(')');

                    u = u.substring(1, u.length());
                    u = u.substring(0,u.length()-1);
                    return sb.append( revers(u) ).toString();
                }
            }
        }

        return sb.toString();
    }

    public String revers(String p){
        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()){
            if(c == '('){
                sb.append(')');
            }else if( c== ')'){
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        System.out.println(solution2.solution("(()())()"));
        System.out.println(solution2.solution(")("));

        System.out.println(solution2.solution("()))((()"));

    }
}
