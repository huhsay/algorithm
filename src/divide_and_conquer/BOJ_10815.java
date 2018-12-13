package divide_and_conquer;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            Integer temp = Integer.valueOf(st.nextToken());
            if(Collections.binarySearch(list, temp) >= 0){
                sb.append("1 ");
                continue;
            }

            sb.append("0 ");
        }

        System.out.println(sb.toString().trim());

    }
}
