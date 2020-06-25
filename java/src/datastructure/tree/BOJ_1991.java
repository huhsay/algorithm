package datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static int N;
    static int[][] tree = new int[26][2];
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int root = st.nextToken().charAt(0) - 65;
            int left = st.nextToken().charAt(0) - 65;
            int right = st.nextToken().charAt(0) - 65;

            tree[root][0] = left;
            tree[root][1] = right;
        }

        sb = new StringBuilder();
        preOrderTraversal(0);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        inOrderTraversal(0);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        postOrderTraversal(0);
        System.out.println(sb.toString());



    }

    public static void preOrderTraversal(int root){
        sb.append((char)(root+65));

        if(tree[root][0] != '.'-65){
            preOrderTraversal(tree[root][0]);
        }

        if(tree[root][1] != '.'-65){
            preOrderTraversal(tree[root][1]);
        }
    }

    public static void inOrderTraversal(int root){
        if(tree[root][0] != '.'-65){
            inOrderTraversal(tree[root][0]);
        }

        sb.append((char)(root+65));

        if(tree[root][1] != '.'-65){
            inOrderTraversal(tree[root][1]);
        }
    }

    public static void postOrderTraversal(int root){
        if(tree[root][0] != '.'-65){
            postOrderTraversal(tree[root][0]);
        }

        if(tree[root][1] != '.'-65){
            postOrderTraversal(tree[root][1]);
        }

        sb.append((char)(root+65));
    }
}
