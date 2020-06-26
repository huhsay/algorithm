package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program_knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] part;
        for (int i = 0; i < commands.length; i++) {
            part = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(part);
            answer[i] = part[commands[i][2]-1];

        }

        return answer;
    }

    public static void main(String[] args) {
        Program_knumber program_knumber = new Program_knumber();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2,5,3,}, {4,4,1}, {1,7,3}};
        System.out.println(Arrays.toString(program_knumber.solution2(array, commands)));

    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < commands.length; i++) {
            start = commands[i][0];
            end = commands[i][1];
            count = 1;
            for (int j = start - 1 ; j < end; j++) {
                if( count == commands[i][2] ){
                    answer[i] = array[j];
                }
                count++;
            }
        }

        return answer;
    }

}
