package datastructure.stack;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    백준 17298 오큰수
    스택
    - 자바를 사용할 경우 pair 를 구현해야 한다.
    - System.out.print 보다는 BufferReader, BufferWriter 를 사용해야한다.
    - 이를 사용하지 않을 경우 시간 초가가 나올 수 도 있다.
 */

public class BOJ_17298_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int answer[] = new int[1000001];
        Arrays.fill(answer, -1);
        Stack<Pair> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            Pair current = new Pair(temp, i);

            while(!stack.isEmpty() && stack.peek().value < current.value){
                Pair a = stack.pop();
                answer[a.index] = current.value;
            }

            stack.add(current);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {

            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}

class Pair{
    public int value;
    public int index;

    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}
