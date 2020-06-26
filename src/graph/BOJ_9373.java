package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9373 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;

    static int x[] = new int[1002];
    static int y[] = new int[1002];
    static int r[] = new int[1002];
    static int leftWallIndex, rightWallIndex;


    public static void main(String[] args) throws IOException {
        int testCase;
        int width;
        int numberOfNode;
        testCase = Integer.parseInt(br.readLine());

        TEST :
        for (int t = 0; t < testCase; t++) {

            Arrays.fill(x, 0);
            Arrays.fill(y, 0);
            Arrays.fill(r, 0);


            width = Integer.parseInt(br.readLine());
            numberOfNode = Integer.parseInt(br.readLine());
            int maxPointNumber = numberOfNode+2;
            parent = new int[maxPointNumber];
            Queue<Edge> edges = new PriorityQueue<>();

            leftWallIndex = numberOfNode;
            rightWallIndex = numberOfNode+1;

            for (int i = 0; i < numberOfNode+2; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < numberOfNode; i++) {
                st = new StringTokenizer(br.readLine());

                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
            }

            x[leftWallIndex] = 0;
            y[leftWallIndex] = 0;
            r[leftWallIndex] = 0;

            x[rightWallIndex] = width;
            y[rightWallIndex] = 0;
            r[rightWallIndex] = 0;

            int cnt = 0;
            double ans = 0;

            //edge 구하기
            edges.add(new Edge(leftWallIndex, rightWallIndex, width));

            for (int i = 0; i < numberOfNode; i++) {
                double value =  Math.sqrt(Math.pow(x[i] - x[leftWallIndex], 2) ) - r[i];
                if(value<0) value = 0;
                edges.add(new Edge(i, leftWallIndex, value));

                value = Math.sqrt(Math.pow(x[i] - x[rightWallIndex], 2) ) - r[i];
                if(value<0) value = 0;
                edges.add(new Edge(i, rightWallIndex, value));

                for (int j = i + 1; j < numberOfNode; j++) {
                    value = calculateDistance(i, j);
                    edges.add(new Edge(i, j, value));
                }
            }

            while (!edges.isEmpty() && cnt < numberOfNode * 2+1) {

                Edge temp = edges.poll();

                int fromIndex = temp.fromIndex;
                int toIndex = temp.toIndex;

                if (union(fromIndex, toIndex)) {
                    cnt++;
                    if (temp.value / 2 > ans) {
                        ans = temp.value / 2;
                    }
                }
            }

            if (find(leftWallIndex) == find(rightWallIndex)){
                System.out.println(ans);
                continue TEST;
            }

            System.out.println(0);
        } // Parent case;
    }

    public static double calculateDistance(int fromIndex, int toIndex){
        double value = Math.sqrt(Math.pow(x[fromIndex] - x[toIndex], 2) + Math.pow(y[fromIndex] - y[toIndex], 2)) - r[fromIndex] - r[toIndex];
        return value <= 0 ? 0 : value;
    }

    public static boolean union(int x, int y) {

        int a = find(x);
        int b = find(y);

        if (a == b) return false;

        parent[b] = a;
        return true;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    public static class Edge implements Comparable<Edge> {
        int fromIndex;
        int toIndex;
        double value;

        public Edge(int from, int to, double value) {
            this.fromIndex = from;
            this.toIndex = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value > o.value ? 1 : this.value == o.value ? 0 : -1;
        }
    }
}
