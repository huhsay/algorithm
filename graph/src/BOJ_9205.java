import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<StationPoint> nextStation = new LinkedList<>();
        StringTokenizer st;

        for(int t = 0; t < T; t++){

            int N = Integer.parseInt(br.readLine());
            StationPoint[] stations = new StationPoint[103];
            boolean[] visited = new boolean[103];

            // 편의점 좌표
            for(int n = 0; n < N+2 ; n++){
                st = new StringTokenizer(br.readLine());
                stations[n] = new StationPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            nextStation.add(stations[0]);
            visited[0] = true;

            boolean flag = false;

            HEAR:
            while(!nextStation.isEmpty()){
                StationPoint current = nextStation.poll();
                for(int i = 0; i < N + 2; i++){
                    if(visited[i]) continue;
                    int temp = Math.abs(current.x - stations[i].x) + Math.abs(current.y - stations[i].y);
                    if(temp <= 1000){
                        if(i == N+1){
                            flag = true;
                            break HEAR;
                        }
                        nextStation.add(stations[i]);
                        visited[i] = true;
                    }
                }
            }

            if(flag){
                System.out.println("happy");
                continue;
            }

            System.out.println("sad");


        }
    }

    static class StationPoint {
        int x;
        int y;

        public StationPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
