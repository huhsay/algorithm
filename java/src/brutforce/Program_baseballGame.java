package brutforce;

import java.util.*;

public class Program_baseballGame {
    public int solution(int[][] baseball) {

        Queue<Integer> numbers = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if( i == j || j == k || k == i ) continue;
                    numbers.add( i * 100 + j * 10 + k);
                }
            }
        }

        int count = 0;
        int number;
        boolean flag;
        while(!numbers.isEmpty()){
            number = numbers.poll();
            flag = true;
            for (int i = 0; i < baseball.length; i++) {
                if( strike(number, baseball[i][0]) != baseball[i][1]) {
                    flag = false;
                    break;
                }
                if( ball(number, baseball[i][0]) != baseball[i][2]) {
                    flag = false;
                    break;
                }
            }

            if(flag) count++;
        }

        return count;

    }

    public int strike(int i, int j){
        int count = 0;

        if( i / 100 == j / 100) count++;
        i = i % 100;
        j = j % 100;
        if( i / 10 == j / 10) count++;
        i = i % 10;
        j = j % 10;
        if( i == j ) count++;

        return count;
    }

    public int ball(int a, int b){
        int i = a;
        int j = b;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add( i / 100);
        set2.add( j / 100);
        i = i % 100;
        j = j % 100;
        set1.add( i / 10);
        set2.add( j / 10);
        i = i % 10;
        j = j % 10;
        set1.add(i);
        set2.add(j);

        Iterator<Integer> iterator = set1.iterator();
        int count = 0;

        while( iterator.hasNext() ) {
            if( set2.contains( iterator.next() )) count++;
        }

        return count - strike(a, b);
    }

    public static void main(String[] args) {
        Program_baseballGame program_baseballGame = new Program_baseballGame();

        int[][] test = {{123, 1, 1}, {356,1,0}, {327,2,0}, {489, 0 ,1}};

        System.out.println(program_baseballGame.strike(132, 123));
        System.out.println(program_baseballGame.ball(132, 123));

        System.out.println( program_baseballGame.solution((test)));
    }
}
