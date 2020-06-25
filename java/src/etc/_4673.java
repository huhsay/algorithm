package etc;

/**
 * 
 * @author theodore
 * baekjoon _4674 _selfnumber
 *
 */

public class _4673 {
	public static void main(String[] args) {
		boolean an[] = new boolean[10001];
		for(int i=1; i<=10000; i++) {
			if(dn(i)<=10000) {
				an[dn(i)]=true;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(an[i]==false) {
				System.out.println(i);
			}
		}
		
	}

	static int dn(int i) {
		int res = i;
		if(res>=10000) { res+= i/10000; i%=10000;}
		if(res>=1000) { res+= i/1000; i%=1000;}
		if(res>=100) { res+= i/100; i%=100;}
		if(res>=10) { res+= i/10; i%=10;}
		if(res>=1) { res+= i/1; i%=1;}

		return res;
	}
}