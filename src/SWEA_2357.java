import java.util.Scanner;

public class SWEA_2357 {
    public static void main(String args[]){
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int test;
        for(int i=1; i<=3; i++){
            boolean ans=false;
            char[] a= sc.next().toCharArray();

            for(char b : a){
                if(b == '9'){
                    ans = true;
                    break;
                }else {
                    ans = false;
                }
            }

            if(ans){
                System.out.println("#"+i+" YES");
                continue;
            }

            System.out.println("#"+i+" NO");
        }
    }
}
