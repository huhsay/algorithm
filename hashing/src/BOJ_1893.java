import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * kmp
 *
 */

public class BOJ_1893 {
    static HashMap<Character, Character> table;

    public static void main(String args[]) throws IOException {
        int N;
        String A;
        String W;
        String S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < N ; i++){
            A = br.readLine();
            W = br.readLine();
            S = br.readLine();

            char[] aArray = A.toCharArray();
            char[] wArray = W.toCharArray();
            char[] sArray = S.toCharArray();

            char[] encoded = wArray;
            List<Integer> ans = new ArrayList<>();

            table = makeHash(aArray);

            for(int j = 1; j <= aArray.length; j++){

                encoded = encode(encoded);
                String code = new String(encoded, 0, encoded.length);

                if(kmp(S, code)){
                    if(j==aArray.length){
                        ans.add(0, 0);
                        continue;
                    }
                    ans.add(j);
                }
            }
            printAns(ans);
        }
    }

    public static HashMap<Character, Character> makeHash(char[] array){
        HashMap<Character,Character> temp = new HashMap<>();
        for(int i = 0; i < array.length-1; i++){
            temp.put(array[i], array[i+1]);
        }
        temp.put(array[array.length-1], array[0]);
        return temp;
    }

    public static char[] encode(char[] encoded){
        char[] temp= new char[encoded.length];
        for(int i = 0; i < encoded.length; i++){
            char c = encoded[i];
            temp[i] = table.get(c);
        }
        return temp;
    }

    public static void printAns(List<Integer> ans){
        if(ans.isEmpty()){
            System.out.println("no solution");
            return;
        }else if(ans.size()==1){
            System.out.print("unique: ");
            System.out.println(ans.remove(0));
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("ambiguous: ");
        while(!ans.isEmpty()){
            sb.append(ans.remove(0));
            sb.append(" ");
        }
        System.out.println(    sb.toString().trim());
    }

    static int[] getPi(String pattern){
        int m = pattern.length();
        int j = 0;
        char[] p;
        int[] pi = new int[m];

        p = pattern.toCharArray();

        for(int i = 1; i < m ; i++){
            while(j > 0 && p[i] != p[j]){
                j = pi[j -1];
            }
            if(p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static boolean kmp(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int n = str.length(), m = pattern.length(), j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for(int i = 0; i < n; i++){
            while(j > 0 && s[i] != p[j]){
                j = pi[j -1];
            }

            if (s[i] == p[j]) {
                if (j == m - 1) {
                    list.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return list.isEmpty() ? false : list.size() > 1 ? false : true;
    }
}