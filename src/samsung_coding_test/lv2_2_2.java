package samsung_coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class lv2_2_2 {
    static int T;
    static int N;
    static int M;
    static int K;
    static int S;

    static int[][] d;

    static int[] DIST; //DIST 넣을 배열
    static int[][] V; //간선의 가중치를 담을 배열
    static int[] Vf; //경로를 담을 배열
    static int t = 0;   //t값을 0으로 초기화 DIST(V1)=0이기 때문
    static boolean[] check;//방문 여부 true/false

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());


            V = new int[N + 1][N + 1];

            Queue<Integer> target = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                target.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < V.length; i++) {
                for (int j = 0; j < V[i].length; j++) {
                    if (i == j) {
                        V[i][j] = 0; //자기 자신은 0
                    } else {
                        V[i][j] = 1000000;   //나머지는 무한대(대신에 100으로,,)로 초기화
                    }

                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                V[from][to] = 1;
                V[to][from] = 1;
            }



            int ans = 0;
            int start = S;
            int end = 0;
            while (!target.isEmpty()) {
                end = target.peek();
                ans += di(start, end);
                start = target.poll();
            }
            ans += di(start, S);

            System.out.println(String.format("#%d %d", t, ans));


        }
    }

    public static int di(int start, int end) {

        DIST = new int[N + 1];
        Vf = new int[N + 1];
        check = new boolean[N + 1];

//end of loop

        check[start] = true;
        Vf[start] = 0;

        for (int i = 0; i < DIST.length; i++) {
            if (i == start) {
                DIST[i] = 0;
            } else {
                DIST[i] = 10000000;
            }
        }

        for (int i = 1; i < DIST.length; i++) {
            for (int k = 1; k < DIST.length; k++) {
                if (check[k] == false) {    //만약 방문하지 않는 노드라면,
                    DIST[k] = Math.min(DIST[k], DIST[t] + V[t][k]);
                }   //t를 거쳐가는게 나은지 MINIMUM함수를 호출하여 검사
            }
            t = i; //일단 t에 i를 넣어주고,
//            3. t를 업데이트 해주는 과정
            for (int j = 1; j < DIST.length; j++) {
                if (check[j] == false) { //아직 방문하지 않은 노드중에
                    // (아직 Vf에 업데이트 되지 않는 노드중에)
                    if (i == DIST.length - 1 || DIST[t] >= DIST[j]) {//만약 Vf에 업데이트되는
                        // 마지막 노드이거나, 남아 있는 값 중 가장 작은 값을 t로 지정
                        t = j;
                    }
                }
            }
            check[t] = true;
            Vf[i] = t;
        }

        return DIST[end];
    }
}

