import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2346 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] map = new int[N+1];
        boolean[] visited = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map[i]=Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int temp;
        StringBuffer ans = new StringBuffer();
        visited[0]=true;
        ans.append(1);
        ans.append(" ");
        for(int i=0; i<N-1; i++){
            temp = map[index];

            if(temp<0){
                temp = -temp;
                for(int j=0; j<temp;j++){
                    index = (index-1+N)%N;
                    while(visited[index]){
                        index = (index-1+N)%N;
                    }
                }

            }else{
                for(int j=0; j<temp;j++){
                    index = (index+1)%N;
                    while(visited[index]){
                        index = (index+1)%N;
                    }
                }
            }

            visited[index] = true;
            int a = index+1;
            ans.append(a);
            ans.append(" ");
        }

        System.out.println(ans);

    }
}
