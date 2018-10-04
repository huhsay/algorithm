import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());

            String[][] map = new String[n][n];

            for (int i = 0; i < n; i++) {
                map[i]=br.readLine().split(" ");
            }


        }
    }
}