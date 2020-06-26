package datastructure.hashing;

import java.io.*;
import java.util.*;

public class ex {
    public static int n;
    public static int[] fail;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static void fail(char[] W) {
        Arrays.fill(fail, 0);
        for(int i = 1, j = 0; i < W.length; i++) {
            while(j > 0 && W[i] != W[j]) j = fail[j - 1];
            if(W[i] == W[j]) fail[i] = ++j;
        }
    }

    public static int KMP(String S, char[] W) {
        int ret = 0;

        for(int i = 0, j = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != W[j]) j = fail[j - 1];
            if(S.charAt(i) == W[j]) {
                ++j;

                if(j == W.length) {
                    ret++;
                    j = fail[j - 1];
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int z = 0; z < testcase; z++) {
            char[] A = br.readLine().toCharArray();
            char[] W = br.readLine().toCharArray();
            String S = br.readLine();
            Map<Character, Integer> ordinary = new HashMap<>();
            Map<Integer, Character> reverse = new HashMap<>();
            n = A.length;
            fail = new int[W.length];

            for(int i = 0; i < n; i++) {
                ordinary.put(A[i], i);
                reverse.put(i, A[i]);
            }

            for(int i = 0; i < n; i++) {
                if(i > 0) {
                    for(int j = 0; j < W.length; j++)
                        W[j] = reverse.get((ordinary.get(W[j]) + 1) % n);
                }

                fail(W);
                if(KMP(S, W) == 1)
                    result.add(i);
            }

            if(result.size() == 0) System.out.println("no solution");
            else if(result.size() == 1) System.out.println("unique: " + result.get(0));
            else {
                System.out.print("ambiguous: ");
                for(int x : result)
                    System.out.print(x + " ");
                System.out.println();
            }

            result.clear();
        }
    }
}