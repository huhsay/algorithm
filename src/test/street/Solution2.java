package test.street;

public class Solution2 {
    int max = 0;
    public int solution(int[] v) {
        int answer = 0;

        perm(v, 0);

        return max;
    }

    private void perm(int[] target, int dep) {
        if( dep == target.length ) {
            compute(target);
            return;
        }
        for (int i = dep; i < target.length; i++) {
            swap(target, dep, i);
            perm(target, dep+1);
            swap(target, dep, i);
        }

    }

    private void compute(int[] target) {
        int ans = 0;
        for (int i = 0; i < target.length - 1; i++) {
            ans += Math.abs(target[i]-target[i+1]);
        }

        max = Math.max(ans, max);
    }

    private void swap(int[] target, int i, int j) {
        int temp  = target[i];
        target[i] = target[j];
        target[j] = temp;
    }

    public static void main(String[] args) {
        int[] v = {100,1,100,1,100,1,100,1};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(v));
    }
}
