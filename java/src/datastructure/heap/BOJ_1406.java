package datastructure.heap;

import java.io.*;
import java.util.*;

public class BOJ_1406 {
    static int N;
    public static void main(String[] args) throws IOException {
        LinkedList<Character> string;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        string = new LinkedList<Character>();

        String firstString = br.readLine();

        for(int i=0; i<firstString.length(); i++){
            string.add(firstString.charAt(i));
        }
        ListIterator iter = string.listIterator(string.size());

        N = Integer.parseInt(br.readLine().trim());

        String oper;
        String tempStr;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            switch (oper){
                case "L" :
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case "D":
                    if(iter.hasNext()) iter.next();
                    break;
                case "B":
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    tempStr = st.nextToken();
                    iter.add(tempStr.charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!string.isEmpty()){
            sb.append(string.remove());
        }
        System.out.println(sb);
    }
}
