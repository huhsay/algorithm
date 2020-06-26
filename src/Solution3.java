import org.junit.Test;

public class Solution3 {
    public int solution(String road, int n) {
        int max;
        int sum = 0;

        String[] roads = road.split("0", -1);
        int[] lengthOfRoads = new int[roads.length];

        String temp;
        String[] splitTemp;
        int countOfDamaged = 0;
        for (int i = 0; i < roads.length; i++) {
            temp = roads[i];

            if (temp.equals("")) {
                countOfDamaged++;
                continue;
            }

            splitTemp = temp.split("");
            lengthOfRoads[i] = splitTemp.length;
        }

        int countToFix = Math.min(countOfDamaged, n);

        for (int i = 0; i < countToFix + 1; i++) {
            sum += lengthOfRoads[i];
        }

        max = sum;

        for (int i = 0; i < roads.length - countToFix-1; i++) {
            sum -= lengthOfRoads[i];
            sum += lengthOfRoads[i+countToFix+1];
            max = Math.max(max, sum);
        }

        return max+countToFix;
    }


    @Test
    public void test() {
        Solution3 solution3 = new Solution3();

        String test2 = "001100";
        String test1 = "111011110011111011111100011111";

        System.out.println(solution3.solution(test2, 5));
    }
}
