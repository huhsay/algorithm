import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * ���� 9007
 * icpc ī������ ����;
 */

public class _9007 {

	static int t,k,n;
	static String s;
	static ArrayList<Integer> c1= new ArrayList<>();
	static ArrayList<Integer> c2= new ArrayList<>();
	static String[] b1=new String[1001];
	static String[] b2=new String[1001];
	static String[] b3=new String[1001];
	static String[] b4=new String[1001];

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t=Integer.parseInt(br.readLine());

		for(int a=0; a<t; a++) {

			st=new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());


			b1=br.readLine().split(" ");
			b2=br.readLine().split(" ");
			b3=br.readLine().split(" ");
			b4=br.readLine().split(" ");

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					c1.add(Integer.parseInt(b1[i])+Integer.parseInt(b2[j]));
					c2.add(Integer.parseInt(b3[i])+Integer.parseInt(b4[j]));
				}
			}

			Collections.sort(c1);

			int abs =40000000;
			int ans =40000000;
			boolean flag = false;

			for(int i=0; i<c1.size(); i++) {
				int temp=c2.get(i);
				int goal=k-temp;
				int index=Collections.binarySearch(c1, goal);

				if(index>0) {
					ans=k;
					System.out.println(k);
					break;

				}else {
					int temp2=40000000;
					if(-(index+1)<n*n) {
						temp2=Math.abs(goal-(c1.get(-(index+1))));
					}
					int temp3=40000000;
					if(-(index+2)>=0) {
						temp3=Math.abs(goal-(c1.get(-(index+2))));
					}
					if(abs>=temp2 || abs>=temp3) {
						if(temp2<temp3) {
							if(abs>temp2) {
								abs = temp2;
								ans = c2.get(i)+c1.get(-(index+1));

								flag=true;
							}else if(abs==temp2) {

								int t1 = c2.get(i)+c1.get(-(index+1));
								if(t1<ans) {
									ans=t1;
								}
								flag=true;
							}
						}else {
							if(abs>temp3) {
								abs = temp3;
								ans = c2.get(i)+c1.get(-(index+2));

								flag=true;
							}else if(abs==temp3) {

								int t1 = c2.get(i)+c1.get(-(index+2));
								if(t1<ans) {
									ans=t1;
								}
								flag=true;
							}
						}
					}
				}
			}

			if(ans!=k && flag) {
				System.out.println(ans);
			}

			c1.clear();
			c2.clear();

			abs =40000000;
			ans =40000000;
		}//for
	}
}
