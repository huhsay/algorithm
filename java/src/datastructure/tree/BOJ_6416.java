package datastructure.tree;

import java.util.*;

public class BOJ_6416 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int testCase = 0;
        Set<Integer> node = new HashSet<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        while(true){

            int u = sc.nextInt();
            int v = sc.nextInt();

            if(u == -1 && v == -1){
                break;
            }

            if(u == 0 && v == 0){
                testCase++;
                boolean ans = true;

                if(indegree.size()!= node.size()-1){
                    ans = false;
                }


                Set<Integer> keys = indegree.keySet();
                for(Integer key : keys){
                    if(indegree.get(key) > 1){
                        ans = false;
                    }
                }

                if(node.size() == 0 && indegree.size()==0){
                    ans = true;
                }

                if(ans){
                    System.out.printf("Case %d is a tree.\n", testCase);
                }else{
                    System.out.printf("Case %d is not a tree.\n", testCase);
                }
                indegree.clear();
                node.clear();
                continue;
            }

            if(indegree.containsKey(v)){
                indegree.put(v, indegree.get(v) + 1);
            }else{
                indegree.put(v, 1);
            }

            node.add(u);
            node.add(v);
        }
    }
}
