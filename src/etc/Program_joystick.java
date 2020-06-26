package etc;

public class Program_joystick {
    public int solution(String name) {
        int[] alp = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11, 10, 9, 8, 7, 6, 5, 4, 3,2,1};
        int answer = 0;
        char[] string = name.toCharArray();

        int index = 0;
        for (int i = 0; i < string.length; i++) {
            index = string[i] - 65;
            answer += alp[index];
        }


        return answer;
    }

    public static void main(String[] args) {
        Program_joystick program_joystick = new Program_joystick();
        System.out.println(program_joystick.solution("JAN"));
    }
}
