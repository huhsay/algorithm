package test.line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution2 {
    static PriorityQueue<Integer> answers = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] intArray = stringArrToIntArray(strings);
        permutation(intArray, 0, intArray.length);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n-1; i++) {
            answers.poll();
        }

        System.out.println(answers.poll());

    }

    private static int[] stringArrToIntArray(String[] stringArray){
        int[] intArray = new int[stringArray.length];

        for (int s = 0; s < stringArray.length; s++) {
            intArray[s] = Integer.parseInt(stringArray[s]);
        }

        return intArray;
    }

    private static void permutation(int[] array, int depth, int n) {
        if(depth == n) {
            answers.add(arrayToInt(array));
            return;
        }

        for(int i=depth; i<n; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, n);
            swap(array, depth, i);
        }
    }

    private static void swap(int[] array, int depth, int i) {
        int temp = array[depth];
        array[depth] = array[i];
        array[i] = temp;
    }

    private static int arrayToInt(int[] arr){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }

}

