package test.nhn2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution3 {
    static int[] candy;
    static int[] follow;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new int[N];
        follow = new int[N];
        Arrays.fill(follow, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        String order;
        int follower;
        int index = -1;
        while(st.hasMoreTokens()){
            order = st.nextToken();
            index = (index + 1 + N) % N;

            switch (order){
                case "A":
                    addCandy(index);
                    break;
                case "J":
                    addCandy((index + N - 1) % N);
                    addCandy((index + N + 1) % N);
                    break;
                case "Q":
                    for (int i = 0; i < N; i++) {
                        candy[i]++;
                    }
                    break;
                case "K":
                    follower = Integer.parseInt(st.nextToken());
                    follow[follower] = index;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(candy[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void addCandy(int index){
        boolean[] visited = new boolean[N];
        candy[index]++;
        visited[index] = true;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if( follow[i] == index && !visited[i]) {
                queue.add(i);
            }
        }

        int currentIndex = 0;
        while(!queue.isEmpty()){
            currentIndex = queue.poll();
            if(visited[currentIndex]) continue;
            visited[currentIndex] = true;
            candy[currentIndex]++;

            for (int i = 0; i < N; i++) {
                if( follow[i] == index && !visited[i]) {
                    queue.add(i);
                }
            }

        }

    }
}
