package divide_and_conquer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * segment tree
 */

public class BOJ_2042 {

    static BigInteger[] tree;
    static BigInteger[] array;

    static int N;
    static int M;
    static int K;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int numberOfNode = (int) Math.ceil(Math.log(N)/Math.log(2));
        tree = new BigInteger[(int) Math.pow(2,numberOfNode)*2];
        array = new BigInteger[N + 3];

        for (int i = 1; i <= N; i++) {
            array[i] = BigInteger.valueOf(Integer.parseInt(br.readLine()));
        }

        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1: {
                    BigInteger diff = BigInteger.valueOf(c).subtract(array[b]);
                    array[b] = BigInteger.valueOf(c);
                    update(1, 1, N, b, diff);
                    break;
                }
                case 2: {
                    System.out.println(sum(1, 1, N, b, c));
                    break;
                }
            }
        }
    }

    public static BigInteger init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = array[start];
        } else {
            return tree[node] = init(node * 2, start, (start + end) / 2).add(init(node * 2 + 1, (start + end) / 2 + 1, end));
        }
    }

    public static BigInteger sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return BigInteger.valueOf(0);
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(node * 2, start, (start + end) / 2, left, right).add(sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
    }

    public static void update(int node, int start, int end, int index, BigInteger diff) {
        if (index < start || index > end) return;
        tree[node] = tree[node].add(diff);
        if (start != end) {
            update(node * 2, start, (start + end) / 2, index, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }
}

class testt {
    @Test
    public void test() {
        BigInteger s = BigInteger.valueOf(3);
        System.out.println(s.subtract(BigInteger.valueOf(4)));
    }
}
