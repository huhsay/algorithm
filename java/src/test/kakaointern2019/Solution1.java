package test.kakaointern2019;

import org.junit.Test;

import java.util.Stack;

public class Solution1 {
    private Stack<Integer> bucket = new Stack<>();
    private int answer = 0;
    public int solution(int[][] board, int[] moves) {

        for (int col : moves) {
            pick(col-1, board);
        }

        return answer;
    }

    private void pick(int col, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            int target;
            if ( board[i][col] != 0) {
                target = board[i][col];
                board[i][col] = 0;

                if (!bucket.isEmpty() && bucket.peek() == target){
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(target);
                }
                break;
            }
        }
    }

    @Test
    public void test() {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
