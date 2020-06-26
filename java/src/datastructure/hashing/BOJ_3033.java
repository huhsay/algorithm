//package datastructure.hashing;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class BOJ_3033 {
//    private static int mod = 100003;
//    private static char[] S;
//
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int L = Integer.parseInt(br.readLine().trim());
//        S = br.readLine().toCharArray();
//
//        int min = 0;
//        int max =  L-1;
//        int mid = 0;
//
//        while(min < max){
//            mid = (min+max)/2;
//
//            int hash = 0, power = 1 ;
//            HashMap<Integer, Integer> hashTable = new HashMap<>();
//            boolean found = false;
//
//            for(int i = 0; i <= mid; i++){
//                if(i == 0){
//                    hash = getHash(i);
//                }else{
//                    hash = getHash(i);
//                }
//            }
//        }
//    }
//}
