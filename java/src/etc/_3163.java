//package etc;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
///*
// *  3163 �������� ����
// *  https://www.acmicpc.net/problem/3163
// *
// */
//
//public class _3163 {
//
//
//	static int T;
//	static int N; //the number of ants;
//	static int L; // length of bar;
//	static int K; //
//
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		T = Integer.parseInt(br.readLine());
//		for(int i=0; i<T; i++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//			List<Ant> ans = new ArrayList<>();
//
//
//			List<Ant> array = new ArrayList<>();
//
//			for(int j=0; j<N; j++) {
//				st = new StringTokenizer(br.readLine());
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				int d = 1;
//				if(b<0) {
//					d =-1;
//				}
//
//				array.add(new Ant(a,b,d));
//			}
//
//			END:
//				while(!array.isEmpty()) {
//
//					int x=0;
//					boolean flag = false;
//
//					if(array.size()==1) {
//
//						ans.add(array.remove(0));
//						break END;
//
//					}else {
//
//						for(int j=0; j<array.size()-1; j++) {
//
//							if(array.get(j).d==1 && array.get(j+1).d!=1) {
//
//								x =j;
//								flag = true;
//								break;
//							}
//						} // array for
//
//
//
//						while(!array.isEmpty()){
//
//							if(array.size()==1) {
//
//								ans.add(array.remove(0));
//
//							}else {
//
//								// ���� ��츦 ������� �Ѵ�.
//								if(array.get(0).l == 30-array.get(array.size()-1).l) {
//
//
//									if(array.get(0).id < array.get(array.size()-1).l) {
//
//										ans.add(array.remove(0));
//										ans.add(array.remove(array.get(array.size()-2).l));
//
//									}else {
//
//										ans.add(array.remove(array.get(array.size()-1).l));
//										ans.add(array.remove(0));
//									}
//
//								}else if(array.get(0).l < 30-array.get(array.size()-1).l) {
//									ans.add(array.remove(0));
//									ans.add(array.remove(array.get(array.size()-1).l));
//
//								}else {
//									ans.add(array.remove(array.get(array.size()-2).l));
//									ans.add(array.remove(0));
//								}
//							}
//
//						}
//
//
//						break END;
//					}
//
//
//					if(flag) {
//
//						int sub = array.get(x+1).l - array.get(x).l;
//
//						if(sub%2==0) { // �������� ������
//							for(int k=0; k<array.size(); k++) {
//
//								if(k==x) {
//									array.get(k).d *= -1;
//									array.get(k).l += sub/2;
//									array.get(k+1).d *= -1;
//									array.get(k+1).l -= sub/2;
//
//									continue;
//								}
//
//								if(array.get(k).d==1) {
//									array.get(k).l+= sub/2;
//								}else {
//									array.get(k).l-= sub/2;
//								}
//
//							}
//						}else { // 0.5 ���� ������
//
//							for(int k=0; k<array.size(); k++) {
//
//								if(k==x) {
//									array.get(k).d *= -1;
//									array.get(k).l += sub/2;
//									array.get(k+1).d *= -1;
//									array.get(k+1).l -= sub/2;
//
//									continue;
//								}
//
//								if(array.get(k).d==1) {
//									array.get(k).l+= (sub/2 +1) ;
//								}else {
//									array.get(k).l-= (sub/2 +1);
//								}
//
//							}
//
//						}
//					}
//					// flag
//
//
//
//					// �������� �������� ���̰� ���� �� �ִ�.
//					if(array.get(0).l<0 || array.get(array.size()-1).l>L) {  // �����ϳ��� ���� ����
//
//
//						if(array.get(0).l<0 && array.get(array.size()-1).l>L) {
//
//							if(-(array.get(0).l) > (array.get(array.size()-1).l - L)) {
//
//								ans.add(array.remove(0));
//
//							}else {
//
//								ans.add(array.remove(array.size()-1));
//							}
//
//
//
//						}else if(array.get(0).l<0) {
//
//							ans.add(array.remove(0));
//
//						}else if(array.get(array.size()-1).l>L) {
//
//							ans.add(array.remove(array.size()-1));
//						}
//
//					}
//
//				} // while
//
//
//			System.out.println(ans.get(K-1).id);
//
//		} // Parent case
//
//
//	}
//
//}
//
//class Ant{
//	int l;
//	int id;
//	int d;
//
//	Ant(int location, int id, int d){
//		this.l = location;
//		this.id = id;
//		this.d = d;
//	}
//}
