import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans=0;
        for (int i = 0; i <8 ; i++) {

            char[] temp =br.readLine().toCharArray();
            int j;
            if(i%2 == 0){
                j =0;
            }else {
                j =1;
            }
            for (; j < 8; j+=2) {
                if(temp[j] == 'F') ans++;
            }
        }

        System.out.println(ans);
    }
}
