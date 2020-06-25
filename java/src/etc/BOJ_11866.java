package etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int n = 1; n <= N; n++) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < M; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" ")+1);
        sb.append(">");

        System.out.println(sb.toString());
    }
}
