package naver;

public class Solution2 {
    int answer = 0;

    public int solution(String[] drum) {

        int N = drum.length;
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = drum[i].toCharArray();
        }
        for (int i = 0; i < N; i++) {
            move(map, i, 0, 0);
        }

        return answer;
    }

    private void move(char[][] drum, int x, int y, int star) {
        if (star == 2) return;
        if (x < 0 || x >= drum.length) return;
        if (y == drum[0].length) {
            answer++;
            return;
        }
        if (drum[y][x] == '#') {
            move(drum, x, y + 1, star);
        }
        if (drum[y][x] == '>') {
            move(drum, x + 1, y, star);
        }
        if (drum[y][x] == '<') {
            move(drum, x - 1, y, star);
        }
        if (drum[y][x] == '*') {
            move(drum, x, y + 1, ++star);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] drum = {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"};

        System.out.println(solution2.solution(drum));
    }

}
