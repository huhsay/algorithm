package programmers;

/*
  프로그래머스 / 깊이.너비 우선탐색 / 네트워크

 */

public class Programmers1 {

    int[][] computers;
    boolean[][] visited;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        int answer = 0;

        visited = new boolean[computers.length][computers.length];

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if(!visited[i][j] && computers[i][j]==1){
                 dfs(i,j);
                 answer++;
                }
            }
        }


        return answer;
    }

    public void dfs(int u, int v){
        visited[u][v] = true;
        for (int i = 0; i < computers.length; i++) {
            if(!visited[v][i] && computers[v][i] == 1){
                dfs(v,i);
            }
        }
    }
}
