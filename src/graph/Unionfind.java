package graph;

public class Unionfind {
    /**
     * 두개의 집합을 통합하는 과정이다.
     * 최소신장트리 구할때 사용된다.
     *  union by rank, path compression
     */

    static int[] parent;

    public Unionfind(int a) {
        parent = new int[a];
    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);// 이렇게 하면 리턴하면서 parent를 한번에 update 할 수 있다.
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);

        if( a==b ) return;

        parent[b] = a;

        /**
         * 양쪽 부모중에 하나에 추가하면 된다.
         * 부모가 한쪽에 부속되면 나머지도 나중에 find하는 과정에서 부모가 없데이트 되겠지..
         *
         * 부모를 바꿔주는 과정에서 변수를 두어 원하는 쪽으로 부모를 두게 할 수 있다.
         * (조건을 추가할 수 있다는 뜻이다.)
         */

    }
}
