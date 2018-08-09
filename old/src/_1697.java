

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
	static int N;
	static int K;
	static Queue<P> q= new LinkedList<>();
	static int[] visited=new int[100003];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		q.add(new P(N, 0));
		visited[N]=1;
		
		while(!q.isEmpty()) {
			P cur = q.remove();
			
			if(cur.x==K){
				System.out.println(cur.l);
                break;
			}
			
			if(cur.x-1>=0 && visited[cur.x-1]==0) {
				P n1 =new P(cur.x-1, cur.l+1);
				visited[n1.x]=n1.l;
				q.add(n1);
			}
			
			if(cur.x+1<=100000 && visited[cur.x+1]==0) {
				P n2 =new P(cur.x+1, cur.l+1);
				visited[n2.x]=n2.l;
				q.add(n2);
			}
			
			if(cur.x*2<=100000 && visited[cur.x*2]==0) {
				P n3 =new P(cur.x*2, cur.l+1);
				visited[n3.x]=n3.l;
				q.add(n3);
			}
		}//while
	}
}

class P{
	int x;
	int l;
	
	P(int x, int l){
		this.x=x;
		this.l=l;
	}
}
