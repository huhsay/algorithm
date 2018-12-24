package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lv1_2 {
    static int T;
    static Queue<Integer> queue = new LinkedList<>();
    static int backnumber;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] mArray = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            int count = 0;
            for (int m = 1; m <= M; m++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 0) {
                    mArray[m] = -1;
                } else {
                    mArray[m] = temp;
                    count += temp;
                }
            }

            st = new StringTokenizer(br.readLine());

            boolean flag = false;
            for (int n = 1; n <= N; n++) {
                int current = Integer.parseInt(st.nextToken());

                if (mArray[current] < 0) {
                    mArray = clean(mArray);
                } else if (mArray[current] == 0) {

                    while (!queue.isEmpty()){

                        int temp = queue.poll();

                        if(temp == current){
                            queue.add(temp);
                            break;
                        }else{
                            mArray[temp]++;
                        }
                    }
                } else {
                    mArray[current]--;
                    queue.add(current);
                }

                if (queue.size() == count) {
                    flag = true;
                    backnumber = n;
                    break;
                }
            }

            int answer = 0;
            if (flag) {
                answer = backnumber - queue.size() + 1;
            }

            System.out.println(String.format("#%d %d", t, answer));

            queue.clear();

        }
    }

    private static int[] clean(int[] mArray) {
        while (!queue.isEmpty()) {
            mArray[queue.poll()]++;
        }
        return mArray;
    }

}
