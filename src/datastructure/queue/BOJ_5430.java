package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/*
    백준 5430 덱
    구현문제 포인터를 사용
    조건을 제대로 확인해야 한다.

 */

public class BOJ_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String a = bufferedReader.readLine();
            bufferedReader.readLine();
            String b = bufferedReader.readLine();
            AC ac = new AC(a, b);
            ac.operate();
            ac.print();
            ac = null;
        }

    }
}

class AC {
    private int head;
    private String functions;
    private LinkedList<String> seq;
    private boolean isError = false;

    public AC(String functions, String seqArray) {
        head = 1;
        this.functions = functions;
        this.seq = stringToLinkedList(seqArray);
    }

    private LinkedList<String> stringToLinkedList(String seqArray) {
        seqArray = seqArray.substring(1, seqArray.length()-1);
        if(seqArray.length() == 0) return new LinkedList<>();
        return new LinkedList<String> (Arrays.asList(seqArray.split(",")));
    }

    public String operate() {
        for (int i = 0; i < functions.length(); i++) {
            char function = functions.charAt(i);

            if(function == 'R') {
                R();
            }else if(function == 'D') {
                D();
            }
        }
        return seq.toString();
    }

    private void R() {
        head = -head;
    }

    private void D() {
        if(seq.isEmpty()) {
            isError = true;
            return;
        }

        if(head == -1) {
            seq.removeLast();
        }else if (head == 1) {
            seq.removeFirst();
        }
    }

    public void print(){
        StringBuilder sb = new StringBuilder();

        if(isError) {
            System.out.println("error");
            return;
        }

        sb.append("[");
        if( head == 1) {
            while(!seq.isEmpty()){
                sb.append(seq.removeFirst()).append(",");
            }
            if(sb.length() != 1) sb.deleteCharAt(sb.length()-1);
        } else if ( head == -1){
            while(!seq.isEmpty()){
                sb.append(seq.removeLast()).append(",");
            }
            if(sb.length() != 1) sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
