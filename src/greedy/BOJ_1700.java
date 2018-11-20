package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1700 {
    static List<Integer> multiTab;
    static int N = 0;
    static int K = 0;
    static int[] kArray = new int[101];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            kArray[k] = Integer.parseInt(st.nextToken());
        }

        multiTab = new ArrayList<>(N);

        int ansCnt = 0;
        for (int i = 0; i < K; i++) {

            if (!isFull()) {
                multiTab.add(kArray[i]);
                count++;
                continue;
            }

            if (multiTab.contains(kArray[i])) continue;

            int selected = choseMutiTap(multiTab, i);
            int temp = kArray[i];
            multiTab.add(multiTab.indexOf(selected), temp);
            ansCnt++;
        }

        System.out.println(ansCnt);
    }

    public static boolean isFull() {
        return N == count;
    }

    public static int choseMutiTap(List<Integer> multiTab, int i) {
        int maxCnt = 0;
        int max = 0;
        for (Integer number : multiTab) {
            int cnt = 0;

            for (int j = i; j < K; j++) {
                if (Integer.valueOf(kArray[j]) == number) {

                    break;
                }
                cnt++;
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                max = number;
            }
        }
        return max;
    }
}
