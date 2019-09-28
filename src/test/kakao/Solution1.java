package test.kakao;

public class Solution1 {

    public int solution(String s) {

        int min = s.length();
        for (int i = 1; i < s.length()/2; i++) {
            int temp = unit(s, i);
            if(min > temp){
                min = temp;
            }
        }

        return min;
    }

    public int unit(String s, int number) {

        int count = 1;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < (s.length()/number) - 1 ; i++) {


            String current = s.substring(number * i, number * (i+1));
            String next = s.substring( number * (i+1), number* (i+2) );

            if( current.equals( next )){
                count++;

                if(i + 2*number == s.length()){
                    sb.append(count + current);
                }

            }else {
                if (count == 1) {
                    sb.append( current );
                } else {
                    sb.append( count + current );
                }
                count = 1;

                if(i + 2*number == s.length()){
                    sb.append(s.substring(number* (i+1), s.length()));
                }
            }
        }

        System.out.println(sb.toString());
        return sb.length();
    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution("aabbaccc"));
        System.out.println(solution1.solution("ababcdcdababcdcd"));
        System.out.println(solution1.solution("abcabcdede"));
        System.out.println(solution1.solution("abcabcabcabcdededededede"));
        System.out.println(solution1.solution("xababcdcdababcdcd"));

    }
}
