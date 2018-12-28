public class test {
}

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        boolean numbers[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            try {
                int number = arr[i];

                if (numbers[number]) {
                    return false;
                }

                numbers[number] = true;

            } catch (Exception e) {
                return false;
            }
        }

        return answer;
    }
}