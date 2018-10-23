package datastructure.heap;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158 {

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        TheoLinkedList dll = new TheoLinkedList();
//
//        for(int i=1; i<=N; i++){
//            dll.add(i);
//        }
//
//        int index = M-1;
//        System.out.print("<");
//        while(dll.size!=1){
//            for(int i=0; i<M-1; i++){
//                dll.addLast(dll.removeFirst());
//            }
//            System.out.print(dll.removeFirst()+", ");
//        }
//
//        System.out.println(dll.removeFirst()+">");
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Integer> dll = new LinkedList<>();

        for(int i=1; i<=N; i++){
            dll.add(i);
        }

        int index = M-1;
        System.out.print("<");
        while(dll.size()!=1){
            for(int i=0; i<M-1; i++){
                dll.addLast(dll.removeFirst());
            }
            System.out.print(dll.removeFirst()+", ");
        }

        System.out.println(dll.removeFirst()+">");
    }
}
