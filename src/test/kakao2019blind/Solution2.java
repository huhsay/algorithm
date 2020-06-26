package test.kakao2019blind;

import org.junit.Test;

import java.util.*;

public class Solution2 {
    public int[] solution(int N, int[] stages) {
        int[] stagePlayers = new int[N + 2];
        Map<Integer, Float> failRateMap = new HashMap<>();

        for (int stage : stages) {
            stagePlayers[stage]++;
        }

        int totalCount = stagePlayers[N + 1];
        for (int i = N; i > 0; i--) {
            totalCount += stagePlayers[i];

            if (totalCount == 0)
                failRateMap.put(i, 0f);
            else
                failRateMap.put(i, (float) stagePlayers[i] / (float) totalCount);
        }

        List<Map.Entry<Integer, Float>> list = new LinkedList<>(failRateMap.entrySet());
        list.sort(
                (o1, o2) -> o2.getValue() - o1.getValue() > 0 ?
                        1 : o2.getValue() - o1.getValue() == 0 ?
                        o1.getKey() - o2.getKey() : -1
        );

        int[] answer = new int[N];
        int count = 0;
        for (Map.Entry<Integer, Float> entry : list) {
            answer[count++] = entry.getKey();
        }

        return answer;
    }

    @Test
    public void countTest() {
        int[] stages = {1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(5, stages)));
    }
}
