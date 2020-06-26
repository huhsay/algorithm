package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713 {


    static private Set<Integer> photo = new LinkedHashSet<>();
    static private int[] recommend = new int[101];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int student;
        for (int i = 0; i < r; i++) {
            student = Integer.parseInt(st.nextToken());

            if( photo.contains(student) ) {
                recommend[student]++;
            } else {
                if ( photo.size() < N) {
                    photo.add(student);
                    recommend[student]++;
                } else {
                    int min = getMinStudent();
                    photo.remove(min);
                    recommend[min] = 0;
                    photo.add(student);
                    recommend[student]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 101; i++) {
            if(recommend[i] != 0) sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int getMinStudent() {
        Iterator<Integer> iterator = photo.iterator();

        int min = 1000;
        int minStudent = 0;
        int student;
        while(iterator.hasNext()) {
            student = iterator.next();
            if(min > recommend[student]) {
                min = recommend[student];
                minStudent = student;
            }
        }

        return minStudent;
    }
}
